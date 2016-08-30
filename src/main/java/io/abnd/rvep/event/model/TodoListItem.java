package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the todo_list_item database table.
 * 
 */
@Entity
@Table(name="todo_list_item")
@NamedQuery(name="TodoListItem.findAll", query="SELECT t FROM TodoListItem t")
public class TodoListItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	private byte enabled;

	private String title;

	//bi-directional many-to-many association to EventItemTask
	@ManyToMany
	@JoinTable(
		name="todo_list_item_event_item_task"
		, joinColumns={
			@JoinColumn(name="todo_list_item_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="event_item_task_id")
			}
		)
	private List<EventItemTask> eventItemTasks;

	//bi-directional many-to-one association to TodoList
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="todo_list_id")
	private TodoList todoList;

	public TodoListItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<EventItemTask> getEventItemTasks() {
		return this.eventItemTasks;
	}

	public void setEventItemTasks(List<EventItemTask> eventItemTasks) {
		this.eventItemTasks = eventItemTasks;
	}

	public TodoList getTodoList() {
		return this.todoList;
	}

	public void setTodoList(TodoList todoList) {
		this.todoList = todoList;
	}

}