package io.abnd.rvep.security.model.impl;

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
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="role_category_id")
	private RoleCategory roleCategory;

	//bi-directional many-to-one association to UserEventRole
	@OneToMany(mappedBy="rvepRole")
	private List<UserEventRole> userEventRoles;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="rvepRole")
	private List<UserRole> userRoles;

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

	public List<UserEventRole> getUserEventRoles() {
		return this.userEventRoles;
	}

	public void setUserEventRoles(List<UserEventRole> userEventRoles) {
		this.userEventRoles = userEventRoles;
	}

	public UserEventRole addUserEventRole(UserEventRole userEventRole) {
		getUserEventRoles().add(userEventRole);
		userEventRole.setRvepRole(this);

		return userEventRole;
	}

	public UserEventRole removeUserEventRole(UserEventRole userEventRole) {
		getUserEventRoles().remove(userEventRole);
		userEventRole.setRvepRole(null);

		return userEventRole;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setRvepRole(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setRvepRole(null);

		return userRole;
	}

}