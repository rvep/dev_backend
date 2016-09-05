package io.abnd.rvep.user.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.event.model.RvepEventInvite;
import io.abnd.rvep.event.model.TodoListItemAssignment;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rvep_user_profile database table.
 * 
 */
@Entity
@Table(name="rvep_user_profile")
@NamedQuery(name="RvepUserProfile.findAll", query="SELECT r FROM RvepUserProfile r")
public class RvepUserProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_login")
	private Date lastLogin;

	//bi-directional many-to-one association to RvepEventInvite
	@OneToMany(mappedBy="rvepUserProfile")
	private List<RvepEventInvite> rvepEventInvites;

	//bi-directional many-to-one association to RvepUserContact
	@OneToMany(mappedBy="rvepUserProfile")
	private List<RvepUserContact> rvepUserContacts;

	//bi-directional many-to-one association to RvepUserContactInvite
	@OneToMany(mappedBy="rvepUserProfile")
	private List<RvepUserContactInvite> rvepUserContactInvites;

	//bi-directional many-to-one association to RvepUser
	@ManyToOne
	@JoinColumn(name="rvep_user_id")
	private RvepUser rvepUser;

	//bi-directional many-to-one association to TodoListItemAssignment
	@OneToMany(mappedBy="rvepUserProfile")
	private List<TodoListItemAssignment> todoListItemAssignments;

	public RvepUserProfile() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<RvepEventInvite> getRvepEventInvites() {
		return this.rvepEventInvites;
	}

	public void setRvepEventInvites(List<RvepEventInvite> rvepEventInvites) {
		this.rvepEventInvites = rvepEventInvites;
	}

	public RvepEventInvite addRvepEventInvite(RvepEventInvite rvepEventInvite) {
		getRvepEventInvites().add(rvepEventInvite);
		rvepEventInvite.setRvepUserProfile(this);

		return rvepEventInvite;
	}

	public RvepEventInvite removeRvepEventInvite(RvepEventInvite rvepEventInvite) {
		getRvepEventInvites().remove(rvepEventInvite);
		rvepEventInvite.setRvepUserProfile(null);

		return rvepEventInvite;
	}

	public List<RvepUserContact> getRvepUserContacts() {
		return this.rvepUserContacts;
	}

	public void setRvepUserContacts(List<RvepUserContact> rvepUserContacts) {
		this.rvepUserContacts = rvepUserContacts;
	}

	public RvepUserContact addRvepUserContact(RvepUserContact rvepUserContact) {
		getRvepUserContacts().add(rvepUserContact);
		rvepUserContact.setRvepUserProfile(this);

		return rvepUserContact;
	}

	public RvepUserContact removeRvepUserContact(RvepUserContact rvepUserContact) {
		getRvepUserContacts().remove(rvepUserContact);
		rvepUserContact.setRvepUserProfile(null);

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
		rvepUserContactInvite.setRvepUserProfile(this);

		return rvepUserContactInvite;
	}

	public RvepUserContactInvite removeRvepUserContactInvite(RvepUserContactInvite rvepUserContactInvite) {
		getRvepUserContactInvites().remove(rvepUserContactInvite);
		rvepUserContactInvite.setRvepUserProfile(null);

		return rvepUserContactInvite;
	}

	public RvepUser getRvepUser() {
		return this.rvepUser;
	}

	public void setRvepUser(RvepUser rvepUser) {
		this.rvepUser = rvepUser;
	}

	public List<TodoListItemAssignment> getTodoListItemAssignments() {
		return this.todoListItemAssignments;
	}

	public void setTodoListItemAssignments(List<TodoListItemAssignment> todoListItemAssignments) {
		this.todoListItemAssignments = todoListItemAssignments;
	}

	public TodoListItemAssignment addTodoListItemAssignment(TodoListItemAssignment todoListItemAssignment) {
		getTodoListItemAssignments().add(todoListItemAssignment);
		todoListItemAssignment.setRvepUserProfile(this);

		return todoListItemAssignment;
	}

	public TodoListItemAssignment removeTodoListItemAssignment(TodoListItemAssignment todoListItemAssignment) {
		getTodoListItemAssignments().remove(todoListItemAssignment);
		todoListItemAssignment.setRvepUserProfile(null);

		return todoListItemAssignment;
	}

}