package io.abnd.rvep.event.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.TodoListItem;

@Repository
public interface TodoListItemDao extends JpaRepository<TodoListItem, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	TodoListItem findById(int id);
	
}
