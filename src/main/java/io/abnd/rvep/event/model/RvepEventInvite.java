package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.user.model.Invite;
import io.abnd.rvep.user.model.RvepUser;
import io.abnd.rvep.user.model.RvepUserProfile;


/**
 * The persistent class for the rvep_event_invite database table.
 * 
 */
@Entity
@Table(name="rvep_event_invite")
@NamedQuery(name="RvepEventInvite.findAll", query="SELECT r FROM RvepEventInvite r")
public class RvepEventInvite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Invite
	@ManyToOne
	private Invite invite;

	//bi-directional many-to-one association to RvepEvent
	@ManyToOne
	@JoinColumn(name="rvep_event_id")
	private RvepEvent rvepEvent;

	//bi-directional many-to-one association to RvepUser
	@ManyToOne
	@JoinColumn(name="rvep_user_id")
	private RvepUser rvepUser;

	//bi-directional many-to-one association to RvepUserProfile
	@ManyToOne
	@JoinColumn(name="rvep_user_profile_id")
	private RvepUserProfile rvepUserProfile;

	public RvepEventInvite() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Invite getInvite() {
		return this.invite;
	}

	public void setInvite(Invite invite) {
		this.invite = invite;
	}

	public RvepEvent getRvepEvent() {
		return this.rvepEvent;
	}

	public void setRvepEvent(RvepEvent rvepEvent) {
		this.rvepEvent = rvepEvent;
	}

	public RvepUser getRvepUser() {
		return this.rvepUser;
	}

	public void setRvepUser(RvepUser rvepUser) {
		this.rvepUser = rvepUser;
	}

	public RvepUserProfile getRvepUserProfile() {
		return this.rvepUserProfile;
	}

	public void setRvepUserProfile(RvepUserProfile rvepUserProfile) {
		this.rvepUserProfile = rvepUserProfile;
	}

}