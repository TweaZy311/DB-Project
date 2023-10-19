package com.example.db_project.services.implementation;

import com.example.db_project.entities.Person;
import com.example.db_project.repositories.PersonRepository;
import com.example.db_project.services.PersonService;
import com.example.db_project.services.base.implementation.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends BaseServiceImpl<Person, Long> implements PersonService {
    @Autowired
    public PersonServiceImpl(PersonRepository repository) {
        super(repository);
    }
}
