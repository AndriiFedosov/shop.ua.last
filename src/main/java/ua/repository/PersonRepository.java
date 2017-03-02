package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import ua.entity.Person;
import ua.entity.Role;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer>{

   @Query(value = "select p from Person p where p.email =?1")
   Person findByEmail(String email);

   Page<Person> findAll(Pageable pageable);

   }
