package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the suggestion database table.
 * 
 */
@Entity
@Table(name="suggestion")
@NamedQuery(name="Suggestion.findAll", query="SELECT s FROM Suggestion s")
public class Suggestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte accepted;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private String description;

	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-one association to RvepEventSuggestion
	@OneToMany(mappedBy="suggestion")
	private List<RvepEventSuggestion> rvepEventSuggestions;

	public Suggestion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAccepted() {
		return this.accepted;
	}

	public void setAccepted(byte accepted) {
		this.accepted = accepted;
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

	public List<RvepEventSuggestion> getRvepEventSuggestions() {
		return this.rvepEventSuggestions;
	}

	public void setRvepEventSuggestions(List<RvepEventSuggestion> rvepEventSuggestions) {
		this.rvepEventSuggestions = rvepEventSuggestions;
	}

	public RvepEventSuggestion addRvepEventSuggestion(RvepEventSuggestion rvepEventSuggestion) {
		getRvepEventSuggestions().add(rvepEventSuggestion);
		rvepEventSuggestion.setSuggestion(this);

		return rvepEventSuggestion;
	}

	public RvepEventSuggestion removeRvepEventSuggestion(RvepEventSuggestion rvepEventSuggestion) {
		getRvepEventSuggestions().remove(rvepEventSuggestion);
		rvepEventSuggestion.setSuggestion(null);

		return rvepEventSuggestion;
	}

}