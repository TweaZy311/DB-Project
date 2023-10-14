package com.example.db_project.controllers;

import com.example.db_project.entities.Person;
import com.example.db_project.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public void addPerson(@RequestBody Person person){
        System.out.println(person);
        personService.addPerson(person);
    }

    @GetMapping("/person/{id}")
    public Optional<Person> getPersonById(@PathVariable ("id") Long id){
        return personService.findById(id);
    }
}
