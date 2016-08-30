package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.security.model.impl.UserEventRole;
import io.abnd.rvep.user.model.RvepUser;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rvep_event database table.
 * 
 */
@Entity
@Table(name="rvep_event")
@NamedQuery(name="RvepEvent.findAll", query="SELECT r FROM RvepEvent r")
public class RvepEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private byte enabled;

	//bi-directional many-to-one association to EventProfile
	@OneToMany(mappedBy="rvepEvent")
	private List<EventProfile> eventProfiles;

	//bi-directional many-to-many association to RollingVote
	@ManyToMany(mappedBy="rvepEvents")
	private List<RollingVote> rollingVotes;

	//bi-directional many-to-many association to Invite
	@ManyToMany
	@JoinTable(
		name="rvep_event_invite"
		, joinColumns={
			@JoinColumn(name="rvep_event_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="invite_id")
			}
		)
	private List<Invite> invites;

	//bi-directional many-to-many association to Suggestion
	@ManyToMany
	@JoinTable(
		name="rvep_event_suggestion"
		, joinColumns={
			@JoinColumn(name="rvep_event_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="suggestion_id")
			}
		)
	private List<Suggestion> suggestions;

	//bi-directional many-to-one association to RvepEventItem
	@OneToMany(mappedBy="rvepEvent")
	private List<RvepEventItem> rvepEventItems;

	//bi-directional many-to-many association to RvepUser
	@ManyToMany(mappedBy="rvepEvents")
	private List<RvepUser> rvepUsers;

	//bi-directional many-to-one association to TodoList
	@OneToMany(mappedBy="rvepEvent")
	private List<TodoList> todoLists;

	//bi-directional many-to-one association to UserEventRole
	@OneToMany(mappedBy="rvepEvent")
	private List<UserEventRole> userEventRoles;

	public RvepEvent() {
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

	public List<EventProfile> getEventProfiles() {
		return this.eventProfiles;
	}

	public void setEventProfiles(List<EventProfile> eventProfiles) {
		this.eventProfiles = eventProfiles;
	}

	public EventProfile addEventProfile(EventProfile eventProfile) {
		getEventProfiles().add(eventProfile);
		eventProfile.setRvepEvent(this);

		return eventProfile;
	}

	public EventProfile removeEventProfile(EventProfile eventProfile) {
		getEventProfiles().remove(eventProfile);
		eventProfile.setRvepEvent(null);

		return eventProfile;
	}

	public List<RollingVote> getRollingVotes() {
		return this.rollingVotes;
	}

	public void setRollingVotes(List<RollingVote> rollingVotes) {
		this.rollingVotes = rollingVotes;
	}

	public List<Invite> getInvites() {
		return this.invites;
	}

	public void setInvites(List<Invite> invites) {
		this.invites = invites;
	}

	public List<Suggestion> getSuggestions() {
		return this.suggestions;
	}

	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

	public List<RvepEventItem> getRvepEventItems() {
		return this.rvepEventItems;
	}

	public void setRvepEventItems(List<RvepEventItem> rvepEventItems) {
		this.rvepEventItems = rvepEventItems;
	}

	public RvepEventItem addRvepEventItem(RvepEventItem rvepEventItem) {
		getRvepEventItems().add(rvepEventItem);
		rvepEventItem.setRvepEvent(this);

		return rvepEventItem;
	}

	public RvepEventItem removeRvepEventItem(RvepEventItem rvepEventItem) {
		getRvepEventItems().remove(rvepEventItem);
		rvepEventItem.setRvepEvent(null);

		return rvepEventItem;
	}

	public List<RvepUser> getRvepUsers() {
		return this.rvepUsers;
	}

	public void setRvepUsers(List<RvepUser> rvepUsers) {
		this.rvepUsers = rvepUsers;
	}

	public List<TodoList> getTodoLists() {
		return this.todoLists;
	}

	public void setTodoLists(List<TodoList> todoLists) {
		this.todoLists = todoLists;
	}

	public TodoList addTodoList(TodoList todoList) {
		getTodoLists().add(todoList);
		todoList.setRvepEvent(this);

		return todoList;
	}

	public TodoList removeTodoList(TodoList todoList) {
		getTodoLists().remove(todoList);
		todoList.setRvepEvent(null);

		return todoList;
	}

	public List<UserEventRole> getUserEventRoles() {
		return this.userEventRoles;
	}

	public void setUserEventRoles(List<UserEventRole> userEventRoles) {
		this.userEventRoles = userEventRoles;
	}

	public UserEventRole addUserEventRole(UserEventRole userEventRole) {
		getUserEventRoles().add(userEventRole);
		userEventRole.setRvepEvent(this);

		return userEventRole;
	}

	public UserEventRole removeUserEventRole(UserEventRole userEventRole) {
		getUserEventRoles().remove(userEventRole);
		userEventRole.setRvepEvent(null);

		return userEventRole;
	}

}