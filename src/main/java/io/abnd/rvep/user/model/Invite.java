package io.abnd.rvep.user.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.event.model.RvepEventInvite;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the invite database table.
 * 
 */
@Entity
@Table(name="invite")
@NamedQuery(name="Invite.findAll", query="SELECT i FROM Invite i")
public class Invite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte accepted;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private byte enabled;

	//bi-directional many-to-one association to RvepEventInvite
	@OneToMany(mappedBy="invite")
	private List<RvepEventInvite> rvepEventInvites;

	public Invite() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAccepted() {
		return this.accepted;
	}

	public void setAccepted(byte accepted) {
		this.accepted = accepted;
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

	public List<RvepEventInvite> getRvepEventInvites() {
		return this.rvepEventInvites;
	}

	public void setRvepEventInvites(List<RvepEventInvite> rvepEventInvites) {
		this.rvepEventInvites = rvepEventInvites;
	}

	public RvepEventInvite addRvepEventInvite(RvepEventInvite rvepEventInvite) {
		getRvepEventInvites().add(rvepEventInvite);
		rvepEventInvite.setInvite(this);

		return rvepEventInvite;
	}

	public RvepEventInvite removeRvepEventInvite(RvepEventInvite rvepEventInvite) {
		getRvepEventInvites().remove(rvepEventInvite);
		rvepEventInvite.setInvite(null);

		return rvepEventInvite;
	}

}