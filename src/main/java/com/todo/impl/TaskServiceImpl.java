package com.todo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.todo.models.TaskList;
import com.todo.repository.TaskRepository;
import com.todo.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	private final TaskRepository taskRepository;

	@Autowired
	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Autowired
	MongoOperations mongoOperations;

	@Override
	public TaskList create(TaskList taskList) {
		return taskRepository.save(taskList);
	}

	@Override
	public void delete(TaskList taskList) {
		taskRepository.delete(taskList);
	}

	@Override
	public TaskList findById(String id) {
		return taskRepository.findById(id);
	}

	@Override
	public List<TaskList> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public TaskList update(TaskList taskList) {
		return taskRepository.save(taskList);
	}

}
