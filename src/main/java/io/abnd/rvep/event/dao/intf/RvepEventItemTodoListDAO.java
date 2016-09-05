package io.abnd.rvep.event.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.RvepEventItemTodoList;

@Repository
public interface RvepEventItemTodoListDAO extends JpaRepository<RvepEventItemTodoList, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	RvepEventItemTodoList findById(int id);
	
}