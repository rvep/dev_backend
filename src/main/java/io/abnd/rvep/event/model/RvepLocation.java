package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rvep_location database table.
 * 
 */
@Entity
@Table(name="rvep_location")
@NamedQuery(name="RvepLocation.findAll", query="SELECT r FROM RvepLocation r")
public class RvepLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	private byte enabled;

	private float geolat;

	private float geolng;

	private String title;

	//bi-directional many-to-one association to RvepEventItem
	@OneToMany(mappedBy="rvepLocation")
	private List<RvepEventItem> rvepEventItems;

	public RvepLocation() {
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

	public float getGeolat() {
		return this.geolat;
	}

	public void setGeolat(float geolat) {
		this.geolat = geolat;
	}

	public float getGeolng() {
		return this.geolng;
	}

	public void setGeolng(float geolng) {
		this.geolng = geolng;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<RvepEventItem> getRvepEventItems() {
		return this.rvepEventItems;
	}

	public void setRvepEventItems(List<RvepEventItem> rvepEventItems) {
		this.rvepEventItems = rvepEventItems;
	}

	public RvepEventItem addRvepEventItem(RvepEventItem rvepEventItem) {
		getRvepEventItems().add(rvepEventItem);
		rvepEventItem.setRvepLocation(this);

		return rvepEventItem;
	}

	public RvepEventItem removeRvepEventItem(RvepEventItem rvepEventItem) {
		getRvepEventItems().remove(rvepEventItem);
		rvepEventItem.setRvepLocation(null);

		return rvepEventItem;
	}

}