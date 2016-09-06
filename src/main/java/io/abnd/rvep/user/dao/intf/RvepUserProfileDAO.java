package io.abnd.rvep.user.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.user.model.RvepUserProfile;

@Repository
public interface RvepUserProfileDAO extends JpaRepository<RvepUserProfile, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepUserProfile findById(int id);

	RvepUserProfile findByEmail(String email);
	
}