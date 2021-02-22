package com.codingdojo.mvc.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.mvc.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
    List<Person> findAll(Sort sortOrder);
}
