package io.abnd.rvep.security.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.security.model.RvepUserRole;

@Repository
public interface RvepUserRoleDAO extends JpaRepository<RvepUserRole, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepUserRole findById(int id);
	
}