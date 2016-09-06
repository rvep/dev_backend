package io.abnd.rvep.security.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.security.model.AuthProvider;

@Repository
public interface AuthProviderDAO extends JpaRepository<AuthProvider, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	AuthProvider findById(int id);

	/**
	 *
	 * @param name
	 * @return
	 */
	AuthProvider findByName(String name);
	
}