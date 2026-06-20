package toDo.com.simple_task_manager.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import toDo.com.simple_task_manager.dto.TaskRequest;
import toDo.com.simple_task_manager.dto.UpdateStatusRequest;
import toDo.com.simple_task_manager.entity.Task;
import toDo.com.simple_task_manager.service.TaskService;

@RestController
@RequestMapping("/task/api")
public class TaskController {
	@Autowired
	private TaskService service;
	
	@PostMapping("/create")
	public void create(TaskRequest task) {
		
		service.createTask(task);
		
	}
	
	
	@GetMapping
	public Optional<Task> getMethods(Long id){
		
		return service.getAllTasks(id);
		
	}
	
	@DeleteMapping
	public String delete(Long id) {
		service.deleteTask(id);
		return "ugurla silindi ";
	}
	
	@PutMapping
	public String update(Long id, TaskRequest task) {
		service.taskUpdate(id, task);
		return "ugurla yenilendi";
	}
	
	@PutMapping("/Status/update")
	public void updateStatus(Long id,UpdateStatusRequest status) {
		service.UpdateStatus(id, status);
	}
	
	@GetMapping("/reminder")
	public List<Task> getTasksDueTomorrow() {
	    return service.getTasksDueTomorrow();
	}
	

}
