package toDo.com.simple_task_manager.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toDo.com.simple_task_manager.dto.PersonRequest;
import toDo.com.simple_task_manager.entity.Person;
import toDo.com.simple_task_manager.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	public void createPerson(PersonRequest person) {

		Person p = new Person();
		p.setFull_name(person.getFull_name());
		p.setGmail(person.getGmail());
		repository.save(p);
	}

	public void deletePerson(Long id) {
		repository.deleteById(id);
	}

	
	public Optional<Person> getById1(Long id){
		return repository.findById(id);
	}

}
