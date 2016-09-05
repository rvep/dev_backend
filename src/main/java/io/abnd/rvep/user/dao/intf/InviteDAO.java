package io.abnd.rvep.user.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.user.model.Invite;

@Repository
public interface InviteDAO extends JpaRepository<Invite, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	Invite findById(int id);
	
}