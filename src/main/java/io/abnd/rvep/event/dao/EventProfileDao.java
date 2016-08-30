package io.abnd.rvep.event.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.EventProfile;

@Repository
public interface EventProfileDao extends JpaRepository<EventProfile, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	EventProfile findById(int id);
	
}
