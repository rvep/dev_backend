package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the todo_list database table.
 * 
 */
@Entity
@Table(name="todo_list")
@NamedQuery(name="TodoList.findAll", query="SELECT t FROM TodoList t")
public class TodoList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private String description;

	private byte enabled;

	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-one association to RvepEventItem
	@OneToMany(mappedBy="todoList")
	private List<RvepEventItem> rvepEventItems;

	//bi-directional many-to-many association to EventItemTask
	@ManyToMany
	@JoinTable(
		name="todo_list_event_item_task"
		, joinColumns={
			@JoinColumn(name="todo_list_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="event_item_task_id")
			}
		)
	private List<EventItemTask> eventItemTasks;

	//bi-directional many-to-one association to RvepEvent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rvep_event_id")
	private RvepEvent rvepEvent;

	//bi-directional many-to-one association to TodoListItem
	@OneToMany(mappedBy="todoList")
	private List<TodoListItem> todoListItems;

	public TodoList() {
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

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public List<RvepEventItem> getRvepEventItems() {
		return this.rvepEventItems;
	}

	public void setRvepEventItems(List<RvepEventItem> rvepEventItems) {
		this.rvepEventItems = rvepEventItems;
	}

	public RvepEventItem addRvepEventItem(RvepEventItem rvepEventItem) {
		getRvepEventItems().add(rvepEventItem);
		rvepEventItem.setTodoList(this);

		return rvepEventItem;
	}

	public RvepEventItem removeRvepEventItem(RvepEventItem rvepEventItem) {
		getRvepEventItems().remove(rvepEventItem);
		rvepEventItem.setTodoList(null);

		return rvepEventItem;
	}

	public List<EventItemTask> getEventItemTasks() {
		return this.eventItemTasks;
	}

	public void setEventItemTasks(List<EventItemTask> eventItemTasks) {
		this.eventItemTasks = eventItemTasks;
	}

	public RvepEvent getRvepEvent() {
		return this.rvepEvent;
	}

	public void setRvepEvent(RvepEvent rvepEvent) {
		this.rvepEvent = rvepEvent;
	}

	public List<TodoListItem> getTodoListItems() {
		return this.todoListItems;
	}

	public void setTodoListItems(List<TodoListItem> todoListItems) {
		this.todoListItems = todoListItems;
	}

	public TodoListItem addTodoListItem(TodoListItem todoListItem) {
		getTodoListItems().add(todoListItem);
		todoListItem.setTodoList(this);

		return todoListItem;
	}

	public TodoListItem removeTodoListItem(TodoListItem todoListItem) {
		getTodoListItems().remove(todoListItem);
		todoListItem.setTodoList(null);

		return todoListItem;
	}

}