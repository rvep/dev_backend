package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rvep_event_suggestion database table.
 * 
 */
@Entity
@Table(name="rvep_event_suggestion")
@NamedQuery(name="RvepEventSuggestion.findAll", query="SELECT r FROM RvepEventSuggestion r")
public class RvepEventSuggestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to RvepEvent
	@ManyToOne
	@JoinColumn(name="rvep_event_id")
	private RvepEvent rvepEvent;

	//bi-directional many-to-one association to Suggestion
	@ManyToOne
	private Suggestion suggestion;

	public RvepEventSuggestion() {
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

	public Suggestion getSuggestion() {
		return this.suggestion;
	}

	public void setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
	}

}