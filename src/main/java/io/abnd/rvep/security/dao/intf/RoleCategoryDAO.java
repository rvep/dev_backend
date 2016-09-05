package io.abnd.rvep.security.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.security.model.RoleCategory;

@Repository
public interface RoleCategoryDAO extends JpaRepository<RoleCategory, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RoleCategory findById(int id);
	
}