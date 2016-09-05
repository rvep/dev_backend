package io.abnd.rvep.security.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.event.model.RvepEvent;
import io.abnd.rvep.user.model.RvepUser;


/**
 * The persistent class for the rvep_user_event_role database table.
 * 
 */
@Entity
@Table(name="rvep_user_event_role")
@NamedQuery(name="RvepUserEventRole.findAll", query="SELECT r FROM RvepUserEventRole r")
public class RvepUserEventRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to RvepEvent
	@ManyToOne
	@JoinColumn(name="rvep_event_id")
	private RvepEvent rvepEvent;

	//bi-directional many-to-one association to RvepRole
	@ManyToOne
	@JoinColumn(name="rvep_role_id")
	private RvepRole rvepRole;

	//bi-directional many-to-one association to RvepUser
	@ManyToOne
	@JoinColumn(name="rvep_user_id")
	private RvepUser rvepUser;

	public RvepUserEventRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RvepEvent getRvepEvent() {
		return this.rvepEvent;
	}

	public void setRvepEvent(RvepEvent rvepEvent) {
		this.rvepEvent = rvepEvent;
	}

	public RvepRole getRvepRole() {
		return this.rvepRole;
	}

	public void setRvepRole(RvepRole rvepRole) {
		this.rvepRole = rvepRole;
	}

	public RvepUser getRvepUser() {
		return this.rvepUser;
	}

	public void setRvepUser(RvepUser rvepUser) {
		this.rvepUser = rvepUser;
	}

}