package io.abnd.rvep.event.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.RvepEventSuggestion;

@Repository
public interface RvepEventSuggestionDAO extends JpaRepository<RvepEventSuggestion, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepEventSuggestion findById(int id);
	
}