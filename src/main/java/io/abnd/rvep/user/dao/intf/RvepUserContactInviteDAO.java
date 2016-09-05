package io.abnd.rvep.user.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.user.model.RvepUserContactInvite;

@Repository
public interface RvepUserContactInviteDAO extends JpaRepository<RvepUserContactInvite, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepUserContactInvite findById(int id);
	
}