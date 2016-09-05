package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rvep_event_item_todo_list database table.
 * 
 */
@Entity
@Table(name="rvep_event_item_todo_list")
@NamedQuery(name="RvepEventItemTodoList.findAll", query="SELECT r FROM RvepEventItemTodoList r")
public class RvepEventItemTodoList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to RvepEvent
	@ManyToOne
	@JoinColumn(name="rvep_event_id")
	private RvepEvent rvepEvent;

	//bi-directional many-to-one association to RvepEventItem
	@ManyToOne
	@JoinColumn(name="rvep_event_item_id")
	private RvepEventItem rvepEventItem;

	//bi-directional many-to-one association to TodoList
	@ManyToOne
	@JoinColumn(name="todo_list_id")
	private TodoList todoList;

	public RvepEventItemTodoList() {
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

	public RvepEventItem getRvepEventItem() {
		return this.rvepEventItem;
	}

	public void setRvepEventItem(RvepEventItem rvepEventItem) {
		this.rvepEventItem = rvepEventItem;
	}

	public TodoList getTodoList() {
		return this.todoList;
	}

	public void setTodoList(TodoList todoList) {
		this.todoList = todoList;
	}

}