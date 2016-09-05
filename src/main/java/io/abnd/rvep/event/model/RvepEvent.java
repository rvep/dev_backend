package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.security.model.RvepUserEventRole;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rvep_event database table.
 * 
 */
@Entity
@Table(name="rvep_event")
@NamedQuery(name="RvepEvent.findAll", query="SELECT r FROM RvepEvent r")
public class RvepEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private byte enabled;

	//bi-directional many-to-one association to RvepEventInvite
	@OneToMany(mappedBy="rvepEvent")
	private List<RvepEventInvite> rvepEventInvites;

	//bi-directional many-to-one association to RvepEventItem
	@OneToMany(mappedBy="rvepEvent")
	private List<RvepEventItem> rvepEventItems;

	//bi-directional many-to-one association to RvepEventItemTodoList
	@OneToMany(mappedBy="rvepEvent")
	private List<RvepEventItemTodoList> rvepEventItemTodoLists;

	//bi-directional many-to-one association to RvepEventProfile
	@OneToMany(mappedBy="rvepEvent")
	private List<RvepEventProfile> rvepEventProfiles;

	//bi-directional many-to-one association to RvepEventSuggestion
	@OneToMany(mappedBy="rvepEvent")
	private List<RvepEventSuggestion> rvepEventSuggestions;

	//bi-directional many-to-one association to RvepEventTodoList
	@OneToMany(mappedBy="rvepEvent")
	private List<RvepEventTodoList> rvepEventTodoLists;

	//bi-directional many-to-one association to RvepUserEventRole
	@OneToMany(mappedBy="rvepEvent")
	private List<RvepUserEventRole> rvepUserEventRoles;

	//bi-directional many-to-one association to RvepUserEventRollingVote
	@OneToMany(mappedBy="rvepEvent")
	private List<RvepUserEventRollingVote> rvepUserEventRollingVotes;

	public RvepEvent() {
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

	public List<RvepEventInvite> getRvepEventInvites() {
		return this.rvepEventInvites;
	}

	public void setRvepEventInvites(List<RvepEventInvite> rvepEventInvites) {
		this.rvepEventInvites = rvepEventInvites;
	}

	public RvepEventInvite addRvepEventInvite(RvepEventInvite rvepEventInvite) {
		getRvepEventInvites().add(rvepEventInvite);
		rvepEventInvite.setRvepEvent(this);

		return rvepEventInvite;
	}

	public RvepEventInvite removeRvepEventInvite(RvepEventInvite rvepEventInvite) {
		getRvepEventInvites().remove(rvepEventInvite);
		rvepEventInvite.setRvepEvent(null);

		return rvepEventInvite;
	}

	public List<RvepEventItem> getRvepEventItems() {
		return this.rvepEventItems;
	}

	public void setRvepEventItems(List<RvepEventItem> rvepEventItems) {
		this.rvepEventItems = rvepEventItems;
	}

	public RvepEventItem addRvepEventItem(RvepEventItem rvepEventItem) {
		getRvepEventItems().add(rvepEventItem);
		rvepEventItem.setRvepEvent(this);

		return rvepEventItem;
	}

	public RvepEventItem removeRvepEventItem(RvepEventItem rvepEventItem) {
		getRvepEventItems().remove(rvepEventItem);
		rvepEventItem.setRvepEvent(null);

		return rvepEventItem;
	}

	public List<RvepEventItemTodoList> getRvepEventItemTodoLists() {
		return this.rvepEventItemTodoLists;
	}

	public void setRvepEventItemTodoLists(List<RvepEventItemTodoList> rvepEventItemTodoLists) {
		this.rvepEventItemTodoLists = rvepEventItemTodoLists;
	}

	public RvepEventItemTodoList addRvepEventItemTodoList(RvepEventItemTodoList rvepEventItemTodoList) {
		getRvepEventItemTodoLists().add(rvepEventItemTodoList);
		rvepEventItemTodoList.setRvepEvent(this);

		return rvepEventItemTodoList;
	}

	public RvepEventItemTodoList removeRvepEventItemTodoList(RvepEventItemTodoList rvepEventItemTodoList) {
		getRvepEventItemTodoLists().remove(rvepEventItemTodoList);
		rvepEventItemTodoList.setRvepEvent(null);

		return rvepEventItemTodoList;
	}

	public List<RvepEventProfile> getRvepEventProfiles() {
		return this.rvepEventProfiles;
	}

	public void setRvepEventProfiles(List<RvepEventProfile> rvepEventProfiles) {
		this.rvepEventProfiles = rvepEventProfiles;
	}

	public RvepEventProfile addRvepEventProfile(RvepEventProfile rvepEventProfile) {
		getRvepEventProfiles().add(rvepEventProfile);
		rvepEventProfile.setRvepEvent(this);

		return rvepEventProfile;
	}

	public RvepEventProfile removeRvepEventProfile(RvepEventProfile rvepEventProfile) {
		getRvepEventProfiles().remove(rvepEventProfile);
		rvepEventProfile.setRvepEvent(null);

		return rvepEventProfile;
	}

	public List<RvepEventSuggestion> getRvepEventSuggestions() {
		return this.rvepEventSuggestions;
	}

	public void setRvepEventSuggestions(List<RvepEventSuggestion> rvepEventSuggestions) {
		this.rvepEventSuggestions = rvepEventSuggestions;
	}

	public RvepEventSuggestion addRvepEventSuggestion(RvepEventSuggestion rvepEventSuggestion) {
		getRvepEventSuggestions().add(rvepEventSuggestion);
		rvepEventSuggestion.setRvepEvent(this);

		return rvepEventSuggestion;
	}

	public RvepEventSuggestion removeRvepEventSuggestion(RvepEventSuggestion rvepEventSuggestion) {
		getRvepEventSuggestions().remove(rvepEventSuggestion);
		rvepEventSuggestion.setRvepEvent(null);

		return rvepEventSuggestion;
	}

	public List<RvepEventTodoList> getRvepEventTodoLists() {
		return this.rvepEventTodoLists;
	}

	public void setRvepEventTodoLists(List<RvepEventTodoList> rvepEventTodoLists) {
		this.rvepEventTodoLists = rvepEventTodoLists;
	}

	public RvepEventTodoList addRvepEventTodoList(RvepEventTodoList rvepEventTodoList) {
		getRvepEventTodoLists().add(rvepEventTodoList);
		rvepEventTodoList.setRvepEvent(this);

		return rvepEventTodoList;
	}

	public RvepEventTodoList removeRvepEventTodoList(RvepEventTodoList rvepEventTodoList) {
		getRvepEventTodoLists().remove(rvepEventTodoList);
		rvepEventTodoList.setRvepEvent(null);

		return rvepEventTodoList;
	}

	public List<RvepUserEventRole> getRvepUserEventRoles() {
		return this.rvepUserEventRoles;
	}

	public void setRvepUserEventRoles(List<RvepUserEventRole> rvepUserEventRoles) {
		this.rvepUserEventRoles = rvepUserEventRoles;
	}

	public RvepUserEventRole addRvepUserEventRole(RvepUserEventRole rvepUserEventRole) {
		getRvepUserEventRoles().add(rvepUserEventRole);
		rvepUserEventRole.setRvepEvent(this);

		return rvepUserEventRole;
	}

	public RvepUserEventRole removeRvepUserEventRole(RvepUserEventRole rvepUserEventRole) {
		getRvepUserEventRoles().remove(rvepUserEventRole);
		rvepUserEventRole.setRvepEvent(null);

		return rvepUserEventRole;
	}

	public List<RvepUserEventRollingVote> getRvepUserEventRollingVotes() {
		return this.rvepUserEventRollingVotes;
	}

	public void setRvepUserEventRollingVotes(List<RvepUserEventRollingVote> rvepUserEventRollingVotes) {
		this.rvepUserEventRollingVotes = rvepUserEventRollingVotes;
	}

	public RvepUserEventRollingVote addRvepUserEventRollingVote(RvepUserEventRollingVote rvepUserEventRollingVote) {
		getRvepUserEventRollingVotes().add(rvepUserEventRollingVote);
		rvepUserEventRollingVote.setRvepEvent(this);

		return rvepUserEventRollingVote;
	}

	public RvepUserEventRollingVote removeRvepUserEventRollingVote(RvepUserEventRollingVote rvepUserEventRollingVote) {
		getRvepUserEventRollingVotes().remove(rvepUserEventRollingVote);
		rvepUserEventRollingVote.setRvepEvent(null);

		return rvepUserEventRollingVote;
	}

}