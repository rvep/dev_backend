package io.abnd.rvep.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.user.model.UserProfile;

@Repository
public interface UserProfileDao extends JpaRepository<UserProfile, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	UserProfile findById(int id);
	
}
