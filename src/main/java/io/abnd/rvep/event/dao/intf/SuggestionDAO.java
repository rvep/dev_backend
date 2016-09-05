package io.abnd.rvep.event.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.Suggestion;

@Repository
public interface SuggestionDAO extends JpaRepository<Suggestion, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	Suggestion findById(int id);
	
}