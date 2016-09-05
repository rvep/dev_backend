package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rolling_vote database table.
 * 
 */
@Entity
@Table(name="rolling_vote")
@NamedQuery(name="RollingVote.findAll", query="SELECT r FROM RollingVote r")
public class RollingVote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private byte enabled;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	private int value;

	//bi-directional many-to-one association to RvepUserEventRollingVote
	@OneToMany(mappedBy="rollingVote")
	private List<RvepUserEventRollingVote> rvepUserEventRollingVotes;

	public RollingVote() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<RvepUserEventRollingVote> getRvepUserEventRollingVotes() {
		return this.rvepUserEventRollingVotes;
	}

	public void setRvepUserEventRollingVotes(List<RvepUserEventRollingVote> rvepUserEventRollingVotes) {
		this.rvepUserEventRollingVotes = rvepUserEventRollingVotes;
	}

	public RvepUserEventRollingVote addRvepUserEventRollingVote(RvepUserEventRollingVote rvepUserEventRollingVote) {
		getRvepUserEventRollingVotes().add(rvepUserEventRollingVote);
		rvepUserEventRollingVote.setRollingVote(this);

		return rvepUserEventRollingVote;
	}

	public RvepUserEventRollingVote removeRvepUserEventRollingVote(RvepUserEventRollingVote rvepUserEventRollingVote) {
		getRvepUserEventRollingVotes().remove(rvepUserEventRollingVote);
		rvepUserEventRollingVote.setRollingVote(null);

		return rvepUserEventRollingVote;
	}

}