package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.user.model.RvepUser;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the event_item_task database table.
 * 
 */
@Entity
@Table(name="event_item_task")
@NamedQuery(name="EventItemTask.findAll", query="SELECT e FROM EventItemTask e")
public class EventItemTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private byte enabled;

	private byte status;

	@Column(name="updated_on")
	private String updatedOn;

	//bi-directional many-to-one association to RvepUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rvep_user_id")
	private RvepUser rvepUser;

	//bi-directional many-to-many association to RvepEventItem
	@ManyToMany(mappedBy="eventItemTasks")
	private List<RvepEventItem> rvepEventItems;

	//bi-directional many-to-many association to TodoList
	@ManyToMany(mappedBy="eventItemTasks")
	private List<TodoList> todoLists;

	//bi-directional many-to-many association to TodoListItem
	@ManyToMany(mappedBy="eventItemTasks")
	private List<TodoListItem> todoListItems;

	public EventItemTask() {
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

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public RvepUser getRvepUser() {
		return this.rvepUser;
	}

	public void setRvepUser(RvepUser rvepUser) {
		this.rvepUser = rvepUser;
	}

	public List<RvepEventItem> getRvepEventItems() {
		return this.rvepEventItems;
	}

	public void setRvepEventItems(List<RvepEventItem> rvepEventItems) {
		this.rvepEventItems = rvepEventItems;
	}

	public List<TodoList> getTodoLists() {
		return this.todoLists;
	}

	public void setTodoLists(List<TodoList> todoLists) {
		this.todoLists = todoLists;
	}

	public List<TodoListItem> getTodoListItems() {
		return this.todoListItems;
	}

	public void setTodoListItems(List<TodoListItem> todoListItems) {
		this.todoListItems = todoListItems;
	}

}