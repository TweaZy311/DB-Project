package com.example.db_project.controllers;

import com.example.db_project.controllers.base.BaseControllerImpl;
import com.example.db_project.entities.Passport;
import com.example.db_project.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PassportController extends BaseControllerImpl<Passport, Long> {

    @Autowired
    public PassportController(BaseService<Passport, Long> baseService) {
        super(baseService);
    }

    @Override
    @PostMapping("/passport")
    public void add(@RequestBody Passport passport) {
        super.add(passport);
    }

    @Override
    @GetMapping("/passport/{id}")
    public Passport getById(@PathVariable("id") Long id) {
        return super.getById(id);
    }
}
