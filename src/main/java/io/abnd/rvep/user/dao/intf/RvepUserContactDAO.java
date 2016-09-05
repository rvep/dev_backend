package io.abnd.rvep.user.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.user.model.RvepUserContact;

@Repository
public interface RvepUserContactDAO extends JpaRepository<RvepUserContact, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepUserContact findById(int id);
	
}