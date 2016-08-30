package io.abnd.rvep.user.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rvep_chip database table.
 * 
 */
@Entity
@Table(name="rvep_chip")
@NamedQuery(name="RvepChip.findAll", query="SELECT r FROM RvepChip r")
public class RvepChip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte[] chip;

	private byte enabled;

	//bi-directional many-to-one association to RvepUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rvep_user_id")
	private RvepUser rvepUser;

	public RvepChip() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getChip() {
		return this.chip;
	}

	public void setChip(byte[] chip) {
		this.chip = chip;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public RvepUser getRvepUser() {
		return this.rvepUser;
	}

	public void setRvepUser(RvepUser rvepUser) {
		this.rvepUser = rvepUser;
	}

}