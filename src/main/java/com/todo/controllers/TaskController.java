package com.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todo.models.TaskList;
import com.todo.services.TaskService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class TaskController {
	@Autowired
	private TaskService taskService;

	TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@RequestMapping(value = "/task", method = RequestMethod.GET)
	public ResponseEntity<TaskList> getTaskById(@RequestParam("id") String id) {
		TaskList task = taskService.findById(id);
		return new ResponseEntity<>(task, HttpStatus.OK);
	}

	@RequestMapping(value = "/task-all", method = RequestMethod.GET)
	public ResponseEntity<List<TaskList>> getTask() {
		List<TaskList> task = taskService.findAll();
		return new ResponseEntity<>(task, HttpStatus.OK);
	}

	@RequestMapping(value = "/task", method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody TaskList taskList) {
		taskService.create(taskList);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/task", method = RequestMethod.PUT)
	public ResponseEntity<TaskList> update(@RequestBody TaskList taskList) {
		taskService.update(taskList);
		return new ResponseEntity<>(taskList, HttpStatus.OK);
	}

	@RequestMapping(value = "/task", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestParam("id") String id) {
		taskService.delete(taskService.findById(id));
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
