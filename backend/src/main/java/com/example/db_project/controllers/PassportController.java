package com.example.db_project.controllers;

import com.example.db_project.controllers.base.BaseControllerImpl;
import com.example.db_project.entities.Passport;
import com.example.db_project.services.PassportService;
import com.example.db_project.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PassportController extends BaseControllerImpl<Passport, Long> {

    @Autowired
    public PassportController(PassportService service) {
        super(service);
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

//    @Override
//    public List<Passport> addAll(List<Passport> passports) {
//        return super.addAll(passports);
//    }
//
//    @Override
//    public void delete(Passport passport) {
//        super.delete(passport);
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//        super.deleteById(aLong);
//    }

    @Override
    @GetMapping("/passport")
    public List<Passport> getAll() {
        return super.getAll();
    }
}
