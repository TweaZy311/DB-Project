package com.example.db_project.services;

import com.example.db_project.entities.Employee;
import com.example.db_project.entities.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person addPerson(Person person);
    List<Person> addPeople(List<Person> people);
    void deletePerson(Person person);
    void deletePersonById(Long id);
    Optional<Person> findById(Long id);
    List<Person> findAll();
}
