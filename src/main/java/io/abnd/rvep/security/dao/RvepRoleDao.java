package io.abnd.rvep.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.security.model.impl.RvepRole;

@Repository
public interface RvepRoleDao extends JpaRepository<RvepRole, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepRole findById(int id);
	
}
