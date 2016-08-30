package io.abnd.rvep.event.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.RvepLocation;

@Repository
public interface RvepLocationDao extends JpaRepository<RvepLocation, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepLocation findById(int id);
	
}
