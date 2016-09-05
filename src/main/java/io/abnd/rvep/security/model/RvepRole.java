package io.abnd.rvep.security.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rvep_role database table.
 * 
 */
@Entity
@Table(name="rvep_role")
@NamedQuery(name="RvepRole.findAll", query="SELECT r FROM RvepRole r")
public class RvepRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte enabled;

	private String name;

	//bi-directional many-to-one association to RoleCategory
	@ManyToOne
	@JoinColumn(name="role_category_id")
	private RoleCategory roleCategory;

	//bi-directional many-to-one association to RvepUserEventRole
	@OneToMany(mappedBy="rvepRole")
	private List<RvepUserEventRole> rvepUserEventRoles;

	//bi-directional many-to-one association to RvepUserRole
	@OneToMany(mappedBy="rvepRole")
	private List<RvepUserRole> rvepUserRoles;

	public RvepRole() {
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

	public RoleCategory getRoleCategory() {
		return this.roleCategory;
	}

	public void setRoleCategory(RoleCategory roleCategory) {
		this.roleCategory = roleCategory;
	}

	public List<RvepUserEventRole> getRvepUserEventRoles() {
		return this.rvepUserEventRoles;
	}

	public void setRvepUserEventRoles(List<RvepUserEventRole> rvepUserEventRoles) {
		this.rvepUserEventRoles = rvepUserEventRoles;
	}

	public RvepUserEventRole addRvepUserEventRole(RvepUserEventRole rvepUserEventRole) {
		getRvepUserEventRoles().add(rvepUserEventRole);
		rvepUserEventRole.setRvepRole(this);

		return rvepUserEventRole;
	}

	public RvepUserEventRole removeRvepUserEventRole(RvepUserEventRole rvepUserEventRole) {
		getRvepUserEventRoles().remove(rvepUserEventRole);
		rvepUserEventRole.setRvepRole(null);

		return rvepUserEventRole;
	}

	public List<RvepUserRole> getRvepUserRoles() {
		return this.rvepUserRoles;
	}

	public void setRvepUserRoles(List<RvepUserRole> rvepUserRoles) {
		this.rvepUserRoles = rvepUserRoles;
	}

	public RvepUserRole addRvepUserRole(RvepUserRole rvepUserRole) {
		getRvepUserRoles().add(rvepUserRole);
		rvepUserRole.setRvepRole(this);

		return rvepUserRole;
	}

	public RvepUserRole removeRvepUserRole(RvepUserRole rvepUserRole) {
		getRvepUserRoles().remove(rvepUserRole);
		rvepUserRole.setRvepRole(null);

		return rvepUserRole;
	}

}