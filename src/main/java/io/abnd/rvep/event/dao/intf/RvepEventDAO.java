package io.abnd.rvep.event.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.RvepEvent;

@Repository
public interface RvepEventDAO extends JpaRepository<RvepEvent, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepEvent findById(int id);
	
}