package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.user.model.RvepUser;


/**
 * The persistent class for the rvep_event_todo_list database table.
 * 
 */
@Entity
@Table(name="rvep_event_todo_list")
@NamedQuery(name="RvepEventTodoList.findAll", query="SELECT r FROM RvepEventTodoList r")
public class RvepEventTodoList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to RvepEvent
	@ManyToOne
	@JoinColumn(name="rvep_event_id")
	private RvepEvent rvepEvent;

	//bi-directional many-to-one association to RvepUser
	@ManyToOne
	@JoinColumn(name="rvep_user_id")
	private RvepUser rvepUser;

	//bi-directional many-to-one association to TodoList
	@ManyToOne
	@JoinColumn(name="todo_list_id")
	private TodoList todoList;

	public RvepEventTodoList() {
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

	public RvepUser getRvepUser() {
		return this.rvepUser;
	}

	public void setRvepUser(RvepUser rvepUser) {
		this.rvepUser = rvepUser;
	}

	public TodoList getTodoList() {
		return this.todoList;
	}

	public void setTodoList(TodoList todoList) {
		this.todoList = todoList;
	}

}