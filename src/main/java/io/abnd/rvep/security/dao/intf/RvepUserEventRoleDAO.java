package io.abnd.rvep.security.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.security.model.RvepUserEventRole;

@Repository
public interface RvepUserEventRoleDAO extends JpaRepository<RvepUserEventRole, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepUserEventRole findById(int id);
	
}