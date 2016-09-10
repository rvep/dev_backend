package io.abnd.rvep.security.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.security.model.RvepUserEventRole;

import java.util.List;

@Repository
public interface RvepUserEventRoleDAO extends JpaRepository<RvepUserEventRole, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepUserEventRole findById(int id);

	/**
	 *
	 * @param rvepUserId
	 * @return
	 */
	List<RvepUserEventRole> findByRvepUserId(int rvepUserId);

	/**
	 *
	 * @param rvepUserId
	 * @param rvepEventId
	 * @return
	 */
	List<RvepUserEventRole> findByRvepUserIdAndRvepEventId(int rvepUserId, int rvepEventId);
	
}