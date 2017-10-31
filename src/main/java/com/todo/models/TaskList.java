package com.todo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "tasklist")
public class TaskList {

	@Id
	private String id;
	private String title;
	private String status;

	public TaskList() {

	}

	public TaskList(String id, String title, String status) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TaskList [id=" + id + ", title=" + title + ", status=" + status + "]";
	}

}
