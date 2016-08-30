package io.abnd.rvep.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.user.model.RvepChip;

@Repository
public interface RvepChipDao extends JpaRepository<RvepChip, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepChip findById(int id);
	
}
