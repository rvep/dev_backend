package io.abnd.rvep.event.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.TodoListItem;

@Repository
public interface TodoListItemDAO extends JpaRepository<TodoListItem, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	TodoListItem findById(int id);
	
}