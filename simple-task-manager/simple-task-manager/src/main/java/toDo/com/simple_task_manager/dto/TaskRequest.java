package toDo.com.simple_task_manager.dto;

import java.time.LocalDate;

import lombok.Data;
import toDo.com.simple_task_manager.entity.Status;

@Data
public class TaskRequest {
	
	
	private String title;

	private String description;
	
	private Status status;

	private LocalDate dueDate;

	private Long assignedPersonId;
}
