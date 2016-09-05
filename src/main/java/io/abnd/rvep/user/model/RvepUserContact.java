package io.abnd.rvep.user.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rvep_user_contact database table.
 * 
 */
@Entity
@Table(name="rvep_user_contact")
@NamedQuery(name="RvepUserContact.findAll", query="SELECT r FROM RvepUserContact r")
public class RvepUserContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to RvepUser
	@ManyToOne
	@JoinColumn(name="rvep_user_id")
	private RvepUser rvepUser;

	//bi-directional many-to-one association to RvepUserProfile
	@ManyToOne
	@JoinColumn(name="rvep_user_profile_id")
	private RvepUserProfile rvepUserProfile;

	public RvepUserContact() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RvepUser getRvepUser() {
		return this.rvepUser;
	}

	public void setRvepUser(RvepUser rvepUser) {
		this.rvepUser = rvepUser;
	}

	public RvepUserProfile getRvepUserProfile() {
		return this.rvepUserProfile;
	}

	public void setRvepUserProfile(RvepUserProfile rvepUserProfile) {
		this.rvepUserProfile = rvepUserProfile;
	}

}