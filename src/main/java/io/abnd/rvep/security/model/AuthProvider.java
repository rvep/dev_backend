package io.abnd.rvep.security.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the auth_provider database table.
 * 
 */
@Entity
@Table(name="auth_provider")
@NamedQuery(name="AuthProvider.findAll", query="SELECT a FROM AuthProvider a")
public class AuthProvider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte enabled;

	private String name;

	//bi-directional many-to-one association to RvepUserAuthProvider
	@OneToMany(mappedBy="authProvider")
	private List<RvepUserAuthProvider> rvepUserAuthProviders;

	public AuthProvider() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RvepUserAuthProvider> getRvepUserAuthProviders() {
		return this.rvepUserAuthProviders;
	}

	public void setRvepUserAuthProviders(List<RvepUserAuthProvider> rvepUserAuthProviders) {
		this.rvepUserAuthProviders = rvepUserAuthProviders;
	}

	public RvepUserAuthProvider addRvepUserAuthProvider(RvepUserAuthProvider rvepUserAuthProvider) {
		getRvepUserAuthProviders().add(rvepUserAuthProvider);
		rvepUserAuthProvider.setAuthProvider(this);

		return rvepUserAuthProvider;
	}

	public RvepUserAuthProvider removeRvepUserAuthProvider(RvepUserAuthProvider rvepUserAuthProvider) {
		getRvepUserAuthProviders().remove(rvepUserAuthProvider);
		rvepUserAuthProvider.setAuthProvider(null);

		return rvepUserAuthProvider;
	}

}