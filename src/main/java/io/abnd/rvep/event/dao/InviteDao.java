package io.abnd.rvep.event.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.Invite;

@Repository
public interface InviteDao extends JpaRepository<Invite, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	Invite findById(int id);
	
}
