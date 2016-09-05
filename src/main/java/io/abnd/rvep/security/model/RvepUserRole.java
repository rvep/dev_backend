package io.abnd.rvep.security.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.user.model.RvepUser;


/**
 * The persistent class for the rvep_user_role database table.
 * 
 */
@Entity
@Table(name="rvep_user_role")
@NamedQuery(name="RvepUserRole.findAll", query="SELECT r FROM RvepUserRole r")
public class RvepUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to RvepRole
	@ManyToOne
	@JoinColumn(name="rvep_role_id")
	private RvepRole rvepRole;

	//bi-directional many-to-one association to RvepUser
	@ManyToOne
	@JoinColumn(name="rvep_user_id")
	private RvepUser rvepUser;

	public RvepUserRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RvepRole getRvepRole() {
		return this.rvepRole;
	}

	public void setRvepRole(RvepRole rvepRole) {
		this.rvepRole = rvepRole;
	}

	public RvepUser getRvepUser() {
		return this.rvepUser;
	}

	public void setRvepUser(RvepUser rvepUser) {
		this.rvepUser = rvepUser;
	}

}