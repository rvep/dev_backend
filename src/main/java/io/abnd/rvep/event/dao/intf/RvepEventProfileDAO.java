package io.abnd.rvep.event.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.RvepEventProfile;

import java.util.List;

@Repository
public interface RvepEventProfileDAO extends JpaRepository<RvepEventProfile, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepEventProfile findById(int id);

	/**
	 *
	 * @param rvepEventId
	 * @return
	 */
	RvepEventProfile findByRvepEventId(int rvepEventId);
	
}