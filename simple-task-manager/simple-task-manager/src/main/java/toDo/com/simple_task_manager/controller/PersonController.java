package toDo.com.simple_task_manager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import toDo.com.simple_task_manager.dto.PersonRequest;
import toDo.com.simple_task_manager.entity.Person;
import toDo.com.simple_task_manager.service.PersonService;

@RestController
@RequestMapping("/person/api")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	
	@PostMapping("/register")
	public void addPerson(PersonRequest person) {
		service.createPerson(person);
	}
	
	@GetMapping("/{id}")
	public Optional<Person> findPerson(Long id){
		return service.getById1(id);
	}
	
	@DeleteMapping
	public String delete(Long id) {
		service.deletePerson(id);
		return "ugurla silindi";
	}

}
