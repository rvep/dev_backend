package io.abnd.rvep.event.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.EventItemTask;

@Repository
public interface EventItemTaskDao extends JpaRepository<EventItemTask, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	public EventItemTask findById(int id);
	
}
