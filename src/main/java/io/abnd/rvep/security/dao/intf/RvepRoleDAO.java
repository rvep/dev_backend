package io.abnd.rvep.security.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.security.model.RvepRole;

@Repository
public interface RvepRoleDAO extends JpaRepository<RvepRole, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepRole findById(int id);

	/**
	 *
	 * @param name
	 * @return
	 */
	RvepRole findByName(String name);
	
}