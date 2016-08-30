package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.user.model.RvepUser;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rolling_vote database table.
 * 
 */
@Entity
@Table(name="rolling_vote")
@NamedQuery(name="RollingVote.findAll", query="SELECT r FROM RollingVote r")
public class RollingVote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private byte enabled;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	private byte value;

	//bi-directional many-to-many association to RvepEvent
	@ManyToMany
	@JoinTable(
		name="rolling_vote_rvep_event"
		, joinColumns={
			@JoinColumn(name="rolling_vote_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="rvep_event_id")
			}
		)
	private List<RvepEvent> rvepEvents;

	//bi-directional many-to-many association to RvepEventItem
	@ManyToMany
	@JoinTable(
		name="rolling_vote_rvep_event_item"
		, joinColumns={
			@JoinColumn(name="rolling_vote_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="rvep_event_item_id")
			}
		)
	private List<RvepEventItem> rvepEventItems;

	//bi-directional many-to-one association to RvepUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rvep_user_id")
	private RvepUser rvepUser;

	//bi-directional many-to-many association to Suggestion
	@ManyToMany
	@JoinTable(
		name="rolling_vote_suggestion"
		, joinColumns={
			@JoinColumn(name="rolling_vote_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="suggestion_id")
			}
		)
	private List<Suggestion> suggestions;

	public RollingVote() {
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

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public byte getValue() {
		return this.value;
	}

	public void setValue(byte value) {
		this.value = value;
	}

	public List<RvepEvent> getRvepEvents() {
		return this.rvepEvents;
	}

	public void setRvepEvents(List<RvepEvent> rvepEvents) {
		this.rvepEvents = rvepEvents;
	}

	public List<RvepEventItem> getRvepEventItems() {
		return this.rvepEventItems;
	}

	public void setRvepEventItems(List<RvepEventItem> rvepEventItems) {
		this.rvepEventItems = rvepEventItems;
	}

	public RvepUser getRvepUser() {
		return this.rvepUser;
	}

	public void setRvepUser(RvepUser rvepUser) {
		this.rvepUser = rvepUser;
	}

	public List<Suggestion> getSuggestions() {
		return this.suggestions;
	}

	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

}