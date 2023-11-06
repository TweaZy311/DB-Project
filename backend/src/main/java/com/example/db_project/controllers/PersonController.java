package com.example.db_project.controllers;

import com.example.db_project.controllers.base.BaseControllerImpl;
import com.example.db_project.entities.Person;
import com.example.db_project.services.PersonService;
import com.example.db_project.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController extends BaseControllerImpl<Person, Long> {
    @Autowired
    public PersonController(PersonService service) {
        super(service);
    }

    @Override
    @PostMapping("/person")
    public void add(@RequestBody Person person){
        super.add(person);
    }

    @Override
    @GetMapping("/person/{id}")
    public Person getById(@PathVariable ("id") Long id){
        return super.getById(id);
    }

    @Override
    public List<Person> addAll(List<Person> people) {
        return super.addAll(people);
    }

    @Override
    public void delete(Person person) {
        super.delete(person);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    @GetMapping("/person")
    public List<Person> getAll() {
        return super.getAll();
    }

}
