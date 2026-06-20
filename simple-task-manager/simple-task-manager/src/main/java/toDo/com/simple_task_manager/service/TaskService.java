package toDo.com.simple_task_manager.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toDo.com.simple_task_manager.dto.TaskRequest;
import toDo.com.simple_task_manager.dto.UpdateStatusRequest;
import toDo.com.simple_task_manager.entity.Person;
import toDo.com.simple_task_manager.entity.Status;
import toDo.com.simple_task_manager.entity.Task;
import toDo.com.simple_task_manager.repository.PersonRepository;
import toDo.com.simple_task_manager.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;

	@Autowired
	private PersonRepository personRepository;

	public void createTask(TaskRequest task) {

		Person person = personRepository.findById(task.getAssignedPersonId()).orElse(null);

		if (person == null) {
			throw new RuntimeException("sexs tapilmadi");
		}

		Task t = new Task();
		t.setTitle(task.getTitle());
		t.setDescription(task.getDescription());
		t.setDueDate(task.getDueDate());
		t.setStatus(task.getStatus());
		t.setAssignedPerson(person);
		repository.save(t);

	}

	public Optional<Task> getAllTasks(Long id) {

		return repository.findById(id);
	}

	public void deleteTask(Long id) {
		repository.deleteById(id);
	}

	public void taskUpdate(Long id, TaskRequest task) {

		Task t = repository.findById(id).orElse(null);

		if (t == null) {
			throw new RuntimeException("task tapilmadi");
		}

		t.setTitle(task.getTitle());
		t.setDescription(task.getDescription());
		t.setDueDate(task.getDueDate());
		t.setStatus(task.getStatus());
		repository.save(t);

	}

	public void UpdateStatus(Long id, UpdateStatusRequest task) {

		Task t = repository.findById(id).orElse(null);

		if (t == null) {
			throw new RuntimeException("task tapilmadi");
		}
		t.setStatus(task.getStatusupdate());
		repository.save(t);
	}
	
	public List<Task> getTasksDueTomorrow() {

	    LocalDate tomorrow = LocalDate.now().plusDays(1);

	    List<Task> result = new ArrayList<>();

	    List<Task> tasks = repository.findAll();

	    for (Task task : tasks) {

	        if (task.getDueDate().equals(tomorrow)
	                && task.getStatus() != Status.Done) {

	            result.add(task);
	        }
	    }

	    return result;
	}
}
