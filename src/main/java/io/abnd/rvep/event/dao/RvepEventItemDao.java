package io.abnd.rvep.event.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.RvepEventItem;

@Repository
public interface RvepEventItemDao extends JpaRepository<RvepEventItem, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepEventItem findById(int id);
	
}
