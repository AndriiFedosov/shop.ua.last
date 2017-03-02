package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.entity.Person;
import ua.entity.Role;

public interface PersonService {


	
	List<Person>findAll();
	
	void delete (int id);
	
	Person findOne(int id);
	
	void save(Person person);

	Person findByEmail(String email);

	Page<Person> findAll(Pageable pageable);

}
