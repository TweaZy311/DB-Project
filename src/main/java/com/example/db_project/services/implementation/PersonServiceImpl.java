package com.example.db_project.services.implementation;

import com.example.db_project.entities.Person;
import com.example.db_project.repositories.PersonRepository;
import com.example.db_project.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> addPeople(List<Person> people) {
        return personRepository.saveAll(people);
    }

    @Override
    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    @Override
    public void deletePersonById(Long id) {
        personRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(Math.toIntExact(id));
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
