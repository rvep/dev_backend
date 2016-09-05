package io.abnd.rvep.user.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.event.model.RvepEventInvite;
import io.abnd.rvep.event.model.RvepEventTodoList;
import io.abnd.rvep.event.model.RvepUserEventRollingVote;
import io.abnd.rvep.event.model.TodoListItemAssignment;
import io.abnd.rvep.security.model.RvepUserAuthProvider;
import io.abnd.rvep.security.model.RvepUserEventRole;
import io.abnd.rvep.security.model.RvepUserRole;

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

	//bi-directional many-to-one association to RvepEventInvite
	@OneToMany(mappedBy="rvepUser")
	private List<RvepEventInvite> rvepEventInvites;

	//bi-directional many-to-one association to RvepEventTodoList
	@OneToMany(mappedBy="rvepUser")
	private List<RvepEventTodoList> rvepEventTodoLists;

	//bi-directional many-to-one association to RvepUserAuthProvider
	@OneToMany(mappedBy="rvepUser")
	private List<RvepUserAuthProvider> rvepUserAuthProviders;

	//bi-directional many-to-one association to RvepUserContact
	@OneToMany(mappedBy="rvepUser")
	private List<RvepUserContact> rvepUserContacts;

	//bi-directional many-to-one association to RvepUserContactInvite
	@OneToMany(mappedBy="rvepUser")
	private List<RvepUserContactInvite> rvepUserContactInvites;

	//bi-directional many-to-one association to RvepUserEventRole
	@OneToMany(mappedBy="rvepUser")
	private List<RvepUserEventRole> rvepUserEventRoles;

	//bi-directional many-to-one association to RvepUserEventRollingVote
	@OneToMany(mappedBy="rvepUser")
	private List<RvepUserEventRollingVote> rvepUserEventRollingVotes;

	//bi-directional many-to-one association to RvepUserProfile
	@OneToMany(mappedBy="rvepUser")
	private List<RvepUserProfile> rvepUserProfiles;

	//bi-directional many-to-one association to RvepUserRole
	@OneToMany(mappedBy="rvepUser")
	private List<RvepUserRole> rvepUserRoles;

	//bi-directional many-to-one association to TodoListItemAssignment
	@OneToMany(mappedBy="rvepUser")
	private List<TodoListItemAssignment> todoListItemAssignments;

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

	public List<RvepEventInvite> getRvepEventInvites() {
		return this.rvepEventInvites;
	}

	public void setRvepEventInvites(List<RvepEventInvite> rvepEventInvites) {
		this.rvepEventInvites = rvepEventInvites;
	}

	public RvepEventInvite addRvepEventInvite(RvepEventInvite rvepEventInvite) {
		getRvepEventInvites().add(rvepEventInvite);
		rvepEventInvite.setRvepUser(this);

		return rvepEventInvite;
	}

	public RvepEventInvite removeRvepEventInvite(RvepEventInvite rvepEventInvite) {
		getRvepEventInvites().remove(rvepEventInvite);
		rvepEventInvite.setRvepUser(null);

		return rvepEventInvite;
	}

	public List<RvepEventTodoList> getRvepEventTodoLists() {
		return this.rvepEventTodoLists;
	}

	public void setRvepEventTodoLists(List<RvepEventTodoList> rvepEventTodoLists) {
		this.rvepEventTodoLists = rvepEventTodoLists;
	}

	public RvepEventTodoList addRvepEventTodoList(RvepEventTodoList rvepEventTodoList) {
		getRvepEventTodoLists().add(rvepEventTodoList);
		rvepEventTodoList.setRvepUser(this);

		return rvepEventTodoList;
	}

	public RvepEventTodoList removeRvepEventTodoList(RvepEventTodoList rvepEventTodoList) {
		getRvepEventTodoLists().remove(rvepEventTodoList);
		rvepEventTodoList.setRvepUser(null);

		return rvepEventTodoList;
	}

	public List<RvepUserAuthProvider> getRvepUserAuthProviders() {
		return this.rvepUserAuthProviders;
	}

	public void setRvepUserAuthProviders(List<RvepUserAuthProvider> rvepUserAuthProviders) {
		this.rvepUserAuthProviders = rvepUserAuthProviders;
	}

	public RvepUserAuthProvider addRvepUserAuthProvider(RvepUserAuthProvider rvepUserAuthProvider) {
		getRvepUserAuthProviders().add(rvepUserAuthProvider);
		rvepUserAuthProvider.setRvepUser(this);

		return rvepUserAuthProvider;
	}

	public RvepUserAuthProvider removeRvepUserAuthProvider(RvepUserAuthProvider rvepUserAuthProvider) {
		getRvepUserAuthProviders().remove(rvepUserAuthProvider);
		rvepUserAuthProvider.setRvepUser(null);

		return rvepUserAuthProvider;
	}

	public List<RvepUserContact> getRvepUserContacts() {
		return this.rvepUserContacts;
	}

	public void setRvepUserContacts(List<RvepUserContact> rvepUserContacts) {
		this.rvepUserContacts = rvepUserContacts;
	}

	public RvepUserContact addRvepUserContact(RvepUserContact rvepUserContact) {
		getRvepUserContacts().add(rvepUserContact);
		rvepUserContact.setRvepUser(this);

		return rvepUserContact;
	}

	public RvepUserContact removeRvepUserContact(RvepUserContact rvepUserContact) {
		getRvepUserContacts().remove(rvepUserContact);
		rvepUserContact.setRvepUser(null);

		return rvepUserContact;
	}

	public List<RvepUserContactInvite> getRvepUserContactInvites() {
		return this.rvepUserContactInvites;
	}

	public void setRvepUserContactInvites(List<RvepUserContactInvite> rvepUserContactInvites) {
		this.rvepUserContactInvites = rvepUserContactInvites;
	}

	public RvepUserContactInvite addRvepUserContactInvite(RvepUserContactInvite rvepUserContactInvite) {
		getRvepUserContactInvites().add(rvepUserContactInvite);
		rvepUserContactInvite.setRvepUser(this);

		return rvepUserContactInvite;
	}

	public RvepUserContactInvite removeRvepUserContactInvite(RvepUserContactInvite rvepUserContactInvite) {
		getRvepUserContactInvites().remove(rvepUserContactInvite);
		rvepUserContactInvite.setRvepUser(null);

		return rvepUserContactInvite;
	}

	public List<RvepUserEventRole> getRvepUserEventRoles() {
		return this.rvepUserEventRoles;
	}

	public void setRvepUserEventRoles(List<RvepUserEventRole> rvepUserEventRoles) {
		this.rvepUserEventRoles = rvepUserEventRoles;
	}

	public RvepUserEventRole addRvepUserEventRole(RvepUserEventRole rvepUserEventRole) {
		getRvepUserEventRoles().add(rvepUserEventRole);
		rvepUserEventRole.setRvepUser(this);

		return rvepUserEventRole;
	}

	public RvepUserEventRole removeRvepUserEventRole(RvepUserEventRole rvepUserEventRole) {
		getRvepUserEventRoles().remove(rvepUserEventRole);
		rvepUserEventRole.setRvepUser(null);

		return rvepUserEventRole;
	}

	public List<RvepUserEventRollingVote> getRvepUserEventRollingVotes() {
		return this.rvepUserEventRollingVotes;
	}

	public void setRvepUserEventRollingVotes(List<RvepUserEventRollingVote> rvepUserEventRollingVotes) {
		this.rvepUserEventRollingVotes = rvepUserEventRollingVotes;
	}

	public RvepUserEventRollingVote addRvepUserEventRollingVote(RvepUserEventRollingVote rvepUserEventRollingVote) {
		getRvepUserEventRollingVotes().add(rvepUserEventRollingVote);
		rvepUserEventRollingVote.setRvepUser(this);

		return rvepUserEventRollingVote;
	}

	public RvepUserEventRollingVote removeRvepUserEventRollingVote(RvepUserEventRollingVote rvepUserEventRollingVote) {
		getRvepUserEventRollingVotes().remove(rvepUserEventRollingVote);
		rvepUserEventRollingVote.setRvepUser(null);

		return rvepUserEventRollingVote;
	}

	public List<RvepUserProfile> getRvepUserProfiles() {
		return this.rvepUserProfiles;
	}

	public void setRvepUserProfiles(List<RvepUserProfile> rvepUserProfiles) {
		this.rvepUserProfiles = rvepUserProfiles;
	}

	public RvepUserProfile addRvepUserProfile(RvepUserProfile rvepUserProfile) {
		getRvepUserProfiles().add(rvepUserProfile);
		rvepUserProfile.setRvepUser(this);

		return rvepUserProfile;
	}

	public RvepUserProfile removeRvepUserProfile(RvepUserProfile rvepUserProfile) {
		getRvepUserProfiles().remove(rvepUserProfile);
		rvepUserProfile.setRvepUser(null);

		return rvepUserProfile;
	}

	public List<RvepUserRole> getRvepUserRoles() {
		return this.rvepUserRoles;
	}

	public void setRvepUserRoles(List<RvepUserRole> rvepUserRoles) {
		this.rvepUserRoles = rvepUserRoles;
	}

	public RvepUserRole addRvepUserRole(RvepUserRole rvepUserRole) {
		getRvepUserRoles().add(rvepUserRole);
		rvepUserRole.setRvepUser(this);

		return rvepUserRole;
	}

	public RvepUserRole removeRvepUserRole(RvepUserRole rvepUserRole) {
		getRvepUserRoles().remove(rvepUserRole);
		rvepUserRole.setRvepUser(null);

		return rvepUserRole;
	}

	public List<TodoListItemAssignment> getTodoListItemAssignments() {
		return this.todoListItemAssignments;
	}

	public void setTodoListItemAssignments(List<TodoListItemAssignment> todoListItemAssignments) {
		this.todoListItemAssignments = todoListItemAssignments;
	}

	public TodoListItemAssignment addTodoListItemAssignment(TodoListItemAssignment todoListItemAssignment) {
		getTodoListItemAssignments().add(todoListItemAssignment);
		todoListItemAssignment.setRvepUser(this);

		return todoListItemAssignment;
	}

	public TodoListItemAssignment removeTodoListItemAssignment(TodoListItemAssignment todoListItemAssignment) {
		getTodoListItemAssignments().remove(todoListItemAssignment);
		todoListItemAssignment.setRvepUser(null);

		return todoListItemAssignment;
	}

}