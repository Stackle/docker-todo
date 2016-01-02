package com.stackle.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TasksController {

	@Autowired
	private TaskRepository taskRepository;
	
	private Object resultSuccess = new Object() {
		  public final boolean success = true;
	};
	
    @RequestMapping("/")
    public Iterable<Task> all() {
        return taskRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Task get(@PathVariable Long id) {
    	return taskRepository.findOne(id);
    }
    
    @RequestMapping("/add/{name}")
    public Task add(@PathVariable String name) {
    	Task task = new Task(name, false);
    	return taskRepository.save(task);
    }
    
    @RequestMapping("/done/{id}")
    public Task done(@PathVariable Long id) {
    	Task task = taskRepository.findOne(id);
    	task.setDone(true);
    	return taskRepository.save(task);
    }
    
    @RequestMapping("/undone/{id}")
    public Task undone(@PathVariable Long id) {
    	Task task = taskRepository.findOne(id);
    	task.setDone(false);
    	return taskRepository.save(task);
    }
    
    @RequestMapping("/delete/{id}")
    public Object delete(@PathVariable Long id) {
    	taskRepository.delete(id);
    	return resultSuccess;
    }
}