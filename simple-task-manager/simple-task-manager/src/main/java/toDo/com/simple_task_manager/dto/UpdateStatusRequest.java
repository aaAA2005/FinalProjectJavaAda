package toDo.com.simple_task_manager.dto;

import lombok.Data;
import toDo.com.simple_task_manager.entity.Status;

@Data
public class UpdateStatusRequest {
	
	private Status statusupdate;

}
