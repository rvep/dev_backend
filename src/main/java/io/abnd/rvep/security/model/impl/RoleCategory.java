package io.abnd.rvep.security.model.impl;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role_category database table.
 * 
 */
@Entity
@Table(name="role_category")
@NamedQuery(name="RoleCategory.findAll", query="SELECT r FROM RoleCategory r")
public class RoleCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte enabled;

	private String name;

	//bi-directional many-to-one association to RvepRole
	@OneToMany(mappedBy="roleCategory")
	private List<RvepRole> rvepRoles;

	public RoleCategory() {
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

	public List<RvepRole> getRvepRoles() {
		return this.rvepRoles;
	}

	public void setRvepRoles(List<RvepRole> rvepRoles) {
		this.rvepRoles = rvepRoles;
	}

	public RvepRole addRvepRole(RvepRole rvepRole) {
		getRvepRoles().add(rvepRole);
		rvepRole.setRoleCategory(this);

		return rvepRole;
	}

	public RvepRole removeRvepRole(RvepRole rvepRole) {
		getRvepRoles().remove(rvepRole);
		rvepRole.setRoleCategory(null);

		return rvepRole;
	}

}