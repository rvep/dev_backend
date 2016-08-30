package io.abnd.rvep.event.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.RvepEvent;

@Repository
public interface RvepEventDao extends JpaRepository<RvepEvent, Integer>  {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepEvent findById(int id);
	
}
