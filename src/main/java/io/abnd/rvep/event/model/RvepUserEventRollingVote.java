package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.user.model.RvepUser;


/**
 * The persistent class for the rvep_user_event_rolling_vote database table.
 * 
 */
@Entity
@Table(name="rvep_user_event_rolling_vote")
@NamedQuery(name="RvepUserEventRollingVote.findAll", query="SELECT r FROM RvepUserEventRollingVote r")
public class RvepUserEventRollingVote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to RollingVote
	@ManyToOne
	@JoinColumn(name="rolling_vote_id")
	private RollingVote rollingVote;

	//bi-directional many-to-one association to RvepEvent
	@ManyToOne
	@JoinColumn(name="rvep_event_id")
	private RvepEvent rvepEvent;

	//bi-directional many-to-one association to RvepUser
	@ManyToOne
	@JoinColumn(name="rvep_user_id")
	private RvepUser rvepUser;

	public RvepUserEventRollingVote() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RollingVote getRollingVote() {
		return this.rollingVote;
	}

	public void setRollingVote(RollingVote rollingVote) {
		this.rollingVote = rollingVote;
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

}