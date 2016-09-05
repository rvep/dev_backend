package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.user.model.RvepUser;
import io.abnd.rvep.user.model.RvepUserProfile;


/**
 * The persistent class for the todo_list_item_assignment database table.
 * 
 */
@Entity
@Table(name="todo_list_item_assignment")
@NamedQuery(name="TodoListItemAssignment.findAll", query="SELECT t FROM TodoListItemAssignment t")
public class TodoListItemAssignment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to RvepUser
	@ManyToOne
	@JoinColumn(name="rvep_user_id")
	private RvepUser rvepUser;

	//bi-directional many-to-one association to RvepUserProfile
	@ManyToOne
	@JoinColumn(name="rvep_user_profile_id")
	private RvepUserProfile rvepUserProfile;

	//bi-directional many-to-one association to TodoListItem
	@ManyToOne
	@JoinColumn(name="todo_list_item_id")
	private TodoListItem todoListItem;

	public TodoListItemAssignment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public TodoListItem getTodoListItem() {
		return this.todoListItem;
	}

	public void setTodoListItem(TodoListItem todoListItem) {
		this.todoListItem = todoListItem;
	}

}