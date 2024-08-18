package com.project.taskmanger.controler;


import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.taskmanger.DTO.CreateTaskDTO;
import com.project.taskmanger.entities.TaskEntity;
import com.project.taskmanger.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService=taskService;
	}
//	@GetMapping("/")
//	public String hello() {
//		return "welcome to my page";
//	}
//	@GetMapping("/hi")
//	public String hi() {
//		return "hi";
//	}
	@GetMapping("")
	public ResponseEntity<List<TaskEntity>>getTasks() {
		var tasks= taskService.getTasks();
		return ResponseEntity.ok(tasks);
	}
	
	
	@GetMapping("/{id}")
		public ResponseEntity<TaskEntity>getTaskById(@PathVariable("id") Integer id){
			var tasks= taskService.getTaskById(id);
			if(tasks==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(tasks);
		}
		
	@PostMapping("")
	public ResponseEntity<TaskEntity> addTasks(@RequestBody CreateTaskDTO body){
		var task =taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline());
		
		return ResponseEntity.ok(task);
		
	}
	
}

