package io.abnd.rvep.security.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.security.model.RvepUserAuthProvider;

@Repository
public interface RvepUserAuthProviderDAO extends JpaRepository<RvepUserAuthProvider, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepUserAuthProvider findById(int id);
	
}