package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
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

	private byte complete;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private String description;

	private byte enabled;

	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-one association to TodoList
	@ManyToOne
	@JoinColumn(name="todo_list_id")
	private TodoList todoList;

	//bi-directional many-to-one association to TodoListItemAssignment
	@OneToMany(mappedBy="todoListItem")
	private List<TodoListItemAssignment> todoListItemAssignments;

	public TodoListItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getComplete() {
		return this.complete;
	}

	public void setComplete(byte complete) {
		this.complete = complete;
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

	public TodoList getTodoList() {
		return this.todoList;
	}

	public void setTodoList(TodoList todoList) {
		this.todoList = todoList;
	}

	public List<TodoListItemAssignment> getTodoListItemAssignments() {
		return this.todoListItemAssignments;
	}

	public void setTodoListItemAssignments(List<TodoListItemAssignment> todoListItemAssignments) {
		this.todoListItemAssignments = todoListItemAssignments;
	}

	public TodoListItemAssignment addTodoListItemAssignment(TodoListItemAssignment todoListItemAssignment) {
		getTodoListItemAssignments().add(todoListItemAssignment);
		todoListItemAssignment.setTodoListItem(this);

		return todoListItemAssignment;
	}

	public TodoListItemAssignment removeTodoListItemAssignment(TodoListItemAssignment todoListItemAssignment) {
		getTodoListItemAssignments().remove(todoListItemAssignment);
		todoListItemAssignment.setTodoListItem(null);

		return todoListItemAssignment;
	}

}