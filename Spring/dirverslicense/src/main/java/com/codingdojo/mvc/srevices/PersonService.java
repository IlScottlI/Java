package com.codingdojo.mvc.srevices;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Person;
import com.codingdojo.mvc.repositories.PersonRepository;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> allPersons() {
        return personRepository.findAll();
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public List<Person> findAll(Sort sortOrder) {
        return personRepository.findAll(sortOrder);
    }
}
