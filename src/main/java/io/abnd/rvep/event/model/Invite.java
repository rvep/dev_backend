package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.user.model.RvepUser;

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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-many association to RvepEvent
	@ManyToMany(mappedBy="invites")
	private List<RvepEvent> rvepEvents;

	//bi-directional many-to-many association to RvepUser
	@ManyToMany(mappedBy="invites")
	private List<RvepUser> rvepUsers;

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

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public List<RvepEvent> getRvepEvents() {
		return this.rvepEvents;
	}

	public void setRvepEvents(List<RvepEvent> rvepEvents) {
		this.rvepEvents = rvepEvents;
	}

	public List<RvepUser> getRvepUsers() {
		return this.rvepUsers;
	}

	public void setRvepUsers(List<RvepUser> rvepUsers) {
		this.rvepUsers = rvepUsers;
	}

}