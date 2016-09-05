package io.abnd.rvep.event.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.RvepEventInvite;

@Repository
public interface RvepEventInviteDAO extends JpaRepository<RvepEventInvite, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepEventInvite findById(int id);
	
}