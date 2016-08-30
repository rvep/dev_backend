package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the event_profile database table.
 * 
 */
@Entity
@Table(name="event_profile")
@NamedQuery(name="EventProfile.findAll", query="SELECT e FROM EventProfile e")
public class EventProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	@Column(name="hash_id")
	private String hashId;

	@Column(name="is_open_enrollment")
	private byte isOpenEnrollment;

	@Column(name="is_public")
	private byte isPublic;

	@Column(name="person_limit")
	private int personLimit;

	private byte[] picture;

	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-one association to RvepEvent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rvep_event_id")
	private RvepEvent rvepEvent;

	public EventProfile() {
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

	public String getHashId() {
		return this.hashId;
	}

	public void setHashId(String hashId) {
		this.hashId = hashId;
	}

	public byte getIsOpenEnrollment() {
		return this.isOpenEnrollment;
	}

	public void setIsOpenEnrollment(byte isOpenEnrollment) {
		this.isOpenEnrollment = isOpenEnrollment;
	}

	public byte getIsPublic() {
		return this.isPublic;
	}

	public void setIsPublic(byte isPublic) {
		this.isPublic = isPublic;
	}

	public int getPersonLimit() {
		return this.personLimit;
	}

	public void setPersonLimit(int personLimit) {
		this.personLimit = personLimit;
	}

	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
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

	public RvepEvent getRvepEvent() {
		return this.rvepEvent;
	}

	public void setRvepEvent(RvepEvent rvepEvent) {
		this.rvepEvent = rvepEvent;
	}

}