package io.abnd.rvep.security.model;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.user.model.RvepUser;


/**
 * The persistent class for the rvep_user_auth_provider database table.
 * 
 */
@Entity
@Table(name="rvep_user_auth_provider")
@NamedQuery(name="RvepUserAuthProvider.findAll", query="SELECT r FROM RvepUserAuthProvider r")
public class RvepUserAuthProvider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to AuthProvider
	@ManyToOne
	@JoinColumn(name="auth_provider_id")
	private AuthProvider authProvider;

	//bi-directional many-to-one association to RvepUser
	@ManyToOne
	@JoinColumn(name="rvep_user_id")
	private RvepUser rvepUser;

	public RvepUserAuthProvider() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AuthProvider getAuthProvider() {
		return this.authProvider;
	}

	public void setAuthProvider(AuthProvider authProvider) {
		this.authProvider = authProvider;
	}

	public RvepUser getRvepUser() {
		return this.rvepUser;
	}

	public void setRvepUser(RvepUser rvepUser) {
		this.rvepUser = rvepUser;
	}

}