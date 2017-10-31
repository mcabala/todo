package com.todo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.todo.models.TaskList;

public interface TaskRepository extends MongoRepository<TaskList, String> {

	TaskList findById(String id);

}
