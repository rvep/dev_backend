package io.abnd.rvep.event.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.RvepEventTodoList;

@Repository
public interface RvepEventTodoListDAO extends JpaRepository<RvepEventTodoList, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepEventTodoList findById(int id);
	
}