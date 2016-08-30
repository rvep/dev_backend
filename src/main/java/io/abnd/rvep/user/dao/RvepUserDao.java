package io.abnd.rvep.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.user.model.RvepUser;

@Repository
public interface RvepUserDao extends JpaRepository<RvepUser, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepUser findById(int id);
	
}
