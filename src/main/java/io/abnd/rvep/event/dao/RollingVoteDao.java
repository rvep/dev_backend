package io.abnd.rvep.event.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.RollingVote;

@Repository
public interface RollingVoteDao extends JpaRepository<RollingVote, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RollingVote findById(int id);
	
}
