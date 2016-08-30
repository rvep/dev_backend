package io.abnd.rvep.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.security.model.impl.UserRole;

@Repository
public interface UserRoleDao extends JpaRepository<UserRole, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	UserRole findById(int id);
	
}
