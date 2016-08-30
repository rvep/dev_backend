package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.user.model.RvepUser;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the suggestion database table.
 * 
 */
@Entity
@Table(name="suggestion")
@NamedQuery(name="Suggestion.findAll", query="SELECT s FROM Suggestion s")
public class Suggestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private String description;

	private byte enabled;

	private byte status;

	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-many association to RollingVote
	@ManyToMany(mappedBy="suggestions")
	private List<RollingVote> rollingVotes;

	//bi-directional many-to-many association to RvepEvent
	@ManyToMany(mappedBy="suggestions")
	private List<RvepEvent> rvepEvents;

	//bi-directional many-to-many association to RvepEventItem
	@ManyToMany(mappedBy="suggestions")
	private List<RvepEventItem> rvepEventItems;

	//bi-directional many-to-one association to RvepUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rvep_user_id")
	private RvepUser rvepUser;

	public Suggestion() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public List<RollingVote> getRollingVotes() {
		return this.rollingVotes;
	}

	public void setRollingVotes(List<RollingVote> rollingVotes) {
		this.rollingVotes = rollingVotes;
	}

	public List<RvepEvent> getRvepEvents() {
		return this.rvepEvents;
	}

	public void setRvepEvents(List<RvepEvent> rvepEvents) {
		this.rvepEvents = rvepEvents;
	}

	public List<RvepEventItem> getRvepEventItems() {
		return this.rvepEventItems;
	}

	public void setRvepEventItems(List<RvepEventItem> rvepEventItems) {
		this.rvepEventItems = rvepEventItems;
	}

	public RvepUser getRvepUser() {
		return this.rvepUser;
	}

	public void setRvepUser(RvepUser rvepUser) {
		this.rvepUser = rvepUser;
	}

}