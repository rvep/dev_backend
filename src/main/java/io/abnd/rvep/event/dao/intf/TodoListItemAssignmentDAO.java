package io.abnd.rvep.event.dao.intf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.abnd.rvep.event.model.TodoListItemAssignment;

@Repository
public interface TodoListItemAssignmentDAO extends JpaRepository<TodoListItemAssignment, Integer> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	TodoListItemAssignment findById(int id);
	
}