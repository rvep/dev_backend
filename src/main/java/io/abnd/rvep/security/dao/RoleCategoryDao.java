package io.abnd.rvep.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.security.model.impl.RoleCategory;

@Repository
public interface RoleCategoryDao extends JpaRepository<RoleCategory, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RoleCategory findById(int id);
	
}
