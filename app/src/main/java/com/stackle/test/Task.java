package com.stackle.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	private Boolean done;
	
	protected Task() {}
	
	public Task(String name, Boolean done) {
		super();
		this.name = name;
		this.done = done;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Boolean getDone() {
		return done;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", done=" + done + "]";
	}
}
