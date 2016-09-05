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

	//bi-directional many-to-one association to RvepEventItemTodoList
	@OneToMany(mappedBy="todoList")
	private List<RvepEventItemTodoList> rvepEventItemTodoLists;

	//bi-directional many-to-one association to RvepEventTodoList
	@OneToMany(mappedBy="todoList")
	private List<RvepEventTodoList> rvepEventTodoLists;

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

	public List<RvepEventItemTodoList> getRvepEventItemTodoLists() {
		return this.rvepEventItemTodoLists;
	}

	public void setRvepEventItemTodoLists(List<RvepEventItemTodoList> rvepEventItemTodoLists) {
		this.rvepEventItemTodoLists = rvepEventItemTodoLists;
	}

	public RvepEventItemTodoList addRvepEventItemTodoList(RvepEventItemTodoList rvepEventItemTodoList) {
		getRvepEventItemTodoLists().add(rvepEventItemTodoList);
		rvepEventItemTodoList.setTodoList(this);

		return rvepEventItemTodoList;
	}

	public RvepEventItemTodoList removeRvepEventItemTodoList(RvepEventItemTodoList rvepEventItemTodoList) {
		getRvepEventItemTodoLists().remove(rvepEventItemTodoList);
		rvepEventItemTodoList.setTodoList(null);

		return rvepEventItemTodoList;
	}

	public List<RvepEventTodoList> getRvepEventTodoLists() {
		return this.rvepEventTodoLists;
	}

	public void setRvepEventTodoLists(List<RvepEventTodoList> rvepEventTodoLists) {
		this.rvepEventTodoLists = rvepEventTodoLists;
	}

	public RvepEventTodoList addRvepEventTodoList(RvepEventTodoList rvepEventTodoList) {
		getRvepEventTodoLists().add(rvepEventTodoList);
		rvepEventTodoList.setTodoList(this);

		return rvepEventTodoList;
	}

	public RvepEventTodoList removeRvepEventTodoList(RvepEventTodoList rvepEventTodoList) {
		getRvepEventTodoLists().remove(rvepEventTodoList);
		rvepEventTodoList.setTodoList(null);

		return rvepEventTodoList;
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