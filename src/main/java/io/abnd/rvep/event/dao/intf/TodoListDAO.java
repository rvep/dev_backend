package io.abnd.rvep.event.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.TodoList;

@Repository
public interface TodoListDAO extends JpaRepository<TodoList, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	TodoList findById(int id);
	
}