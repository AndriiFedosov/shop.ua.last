package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.entity.Person;
import ua.entity.Role;
import ua.repository.PersonRepository;
import ua.service.PersonService;

import javax.annotation.PostConstruct;

@Service("userDetailsService")
public class PersonServiceImpl implements PersonService,UserDetailsService{

	@Autowired
	private PersonRepository personRepository;

	public Page<Person> findAll(Pageable pageable) {
		return personRepository.findAll(pageable);
	}

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public void delete(int id) {
		personRepository.delete(id);
	}

	public Person findOne(int id) {
		return personRepository.findOne(id);
	}



    @Override
    public Person findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return personRepository.findByEmail(username);
	}

	@Override
	public void save(Person user) {
		user.setPasswordUser(encoder.encode(user.getPassword()));
		user.setRole(Role.USER);
		personRepository.save(user);
	}

	@PostConstruct
	public void admin(){
		Person user = personRepository.findByEmail("admin");
		if(user==null){
			user = new Person();
			user.setEmail("");
			user.setPasswordUser(encoder.encode("admin"));
			user.setRole(Role.ADMIN);
			personRepository.save(user);
		}
	}


}





