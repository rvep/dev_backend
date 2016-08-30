package io.abnd.rvep.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.security.model.impl.UserEventRole;

@Repository
public interface UserEventRoleDao extends JpaRepository<UserEventRole, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	UserEventRole findById(int id);
	
}
