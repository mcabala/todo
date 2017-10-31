package com.todo.services;

import java.util.List;

import com.todo.models.TaskList;

public interface TaskService {

	TaskList create(TaskList taskList);

	List<TaskList> findAll();

	void delete(TaskList taskList);

	TaskList findById(String id);
	
	TaskList update(TaskList taskList);

}
