package io.abnd.rvep.user.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.event.model.EventItemTask;
import io.abnd.rvep.event.model.Invite;
import io.abnd.rvep.event.model.RollingVote;
import io.abnd.rvep.event.model.RvepEvent;
import io.abnd.rvep.event.model.Suggestion;
import io.abnd.rvep.security.model.impl.UserEventRole;
import io.abnd.rvep.security.model.impl.UserRole;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rvep_user database table.
 * 
 */
@Entity
@Table(name="rvep_user")
@NamedQuery(name="RvepUser.findAll", query="SELECT r FROM RvepUser r")
public class RvepUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private byte enabled;

	//bi-directional many-to-one association to EventItemTask
	@OneToMany(mappedBy="rvepUser")
	private List<EventItemTask> eventItemTasks;

	//bi-directional many-to-one association to RollingVote
	@OneToMany(mappedBy="rvepUser")
	private List<RollingVote> rollingVotes;

	//bi-directional many-to-one association to RvepChip
	@OneToMany(mappedBy="rvepUser")
	private List<RvepChip> rvepChips;

	//bi-directional many-to-many association to Invite
	@ManyToMany
	@JoinTable(
		name="rvep_user_invite"
		, joinColumns={
			@JoinColumn(name="rvep_user_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="invite_id")
			}
		)
	private List<Invite> invites;

	//bi-directional many-to-many association to RvepEvent
	@ManyToMany
	@JoinTable(
		name="rvep_user_event"
		, joinColumns={
			@JoinColumn(name="rvep_user_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="rvep_event_id")
			}
		)
	private List<RvepEvent> rvepEvents;

	//bi-directional many-to-one association to Suggestion
	@OneToMany(mappedBy="rvepUser")
	private List<Suggestion> suggestions;

	//bi-directional many-to-one association to UserEventRole
	@OneToMany(mappedBy="rvepUser")
	private List<UserEventRole> userEventRoles;

	//bi-directional many-to-many association to UserProfile
	@ManyToMany(mappedBy="rvepUsers")
	private List<UserProfile> userProfiles1;

	//bi-directional many-to-one association to UserProfile
	@OneToMany(mappedBy="rvepUser")
	private List<UserProfile> userProfiles2;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="rvepUser")
	private List<UserRole> userRoles;

	public RvepUser() {
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

	public List<EventItemTask> getEventItemTasks() {
		return this.eventItemTasks;
	}

	public void setEventItemTasks(List<EventItemTask> eventItemTasks) {
		this.eventItemTasks = eventItemTasks;
	}

	public EventItemTask addEventItemTask(EventItemTask eventItemTask) {
		getEventItemTasks().add(eventItemTask);
		eventItemTask.setRvepUser(this);

		return eventItemTask;
	}

	public EventItemTask removeEventItemTask(EventItemTask eventItemTask) {
		getEventItemTasks().remove(eventItemTask);
		eventItemTask.setRvepUser(null);

		return eventItemTask;
	}

	public List<RollingVote> getRollingVotes() {
		return this.rollingVotes;
	}

	public void setRollingVotes(List<RollingVote> rollingVotes) {
		this.rollingVotes = rollingVotes;
	}

	public RollingVote addRollingVote(RollingVote rollingVote) {
		getRollingVotes().add(rollingVote);
		rollingVote.setRvepUser(this);

		return rollingVote;
	}

	public RollingVote removeRollingVote(RollingVote rollingVote) {
		getRollingVotes().remove(rollingVote);
		rollingVote.setRvepUser(null);

		return rollingVote;
	}

	public List<RvepChip> getRvepChips() {
		return this.rvepChips;
	}

	public void setRvepChips(List<RvepChip> rvepChips) {
		this.rvepChips = rvepChips;
	}

	public RvepChip addRvepChip(RvepChip rvepChip) {
		getRvepChips().add(rvepChip);
		rvepChip.setRvepUser(this);

		return rvepChip;
	}

	public RvepChip removeRvepChip(RvepChip rvepChip) {
		getRvepChips().remove(rvepChip);
		rvepChip.setRvepUser(null);

		return rvepChip;
	}

	public List<Invite> getInvites() {
		return this.invites;
	}

	public void setInvites(List<Invite> invites) {
		this.invites = invites;
	}

	public List<RvepEvent> getRvepEvents() {
		return this.rvepEvents;
	}

	public void setRvepEvents(List<RvepEvent> rvepEvents) {
		this.rvepEvents = rvepEvents;
	}

	public List<Suggestion> getSuggestions() {
		return this.suggestions;
	}

	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

	public Suggestion addSuggestion(Suggestion suggestion) {
		getSuggestions().add(suggestion);
		suggestion.setRvepUser(this);

		return suggestion;
	}

	public Suggestion removeSuggestion(Suggestion suggestion) {
		getSuggestions().remove(suggestion);
		suggestion.setRvepUser(null);

		return suggestion;
	}

	public List<UserEventRole> getUserEventRoles() {
		return this.userEventRoles;
	}

	public void setUserEventRoles(List<UserEventRole> userEventRoles) {
		this.userEventRoles = userEventRoles;
	}

	public UserEventRole addUserEventRole(UserEventRole userEventRole) {
		getUserEventRoles().add(userEventRole);
		userEventRole.setRvepUser(this);

		return userEventRole;
	}

	public UserEventRole removeUserEventRole(UserEventRole userEventRole) {
		getUserEventRoles().remove(userEventRole);
		userEventRole.setRvepUser(null);

		return userEventRole;
	}

	public List<UserProfile> getUserProfiles1() {
		return this.userProfiles1;
	}

	public void setUserProfiles1(List<UserProfile> userProfiles1) {
		this.userProfiles1 = userProfiles1;
	}

	public List<UserProfile> getUserProfiles2() {
		return this.userProfiles2;
	}

	public void setUserProfiles2(List<UserProfile> userProfiles2) {
		this.userProfiles2 = userProfiles2;
	}

	public UserProfile addUserProfiles2(UserProfile userProfiles2) {
		getUserProfiles2().add(userProfiles2);
		userProfiles2.setRvepUser(this);

		return userProfiles2;
	}

	public UserProfile removeUserProfiles2(UserProfile userProfiles2) {
		getUserProfiles2().remove(userProfiles2);
		userProfiles2.setRvepUser(null);

		return userProfiles2;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setRvepUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setRvepUser(null);

		return userRole;
	}

}