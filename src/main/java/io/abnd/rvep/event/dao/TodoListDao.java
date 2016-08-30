package io.abnd.rvep.event.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.TodoList;

@Repository
public interface TodoListDao extends JpaRepository<TodoList, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	TodoList findById(int id);
	
}
