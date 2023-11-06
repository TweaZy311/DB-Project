package com.example.db_project.controllers;


import com.example.db_project.controllers.base.BaseControllerImpl;
import com.example.db_project.entities.Passenger;
import com.example.db_project.services.PassengerService;
import com.example.db_project.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PassengerController extends BaseControllerImpl<Passenger, Long> {
    @Autowired
    public PassengerController(PassengerService service) {
        super(service);
    }

    @Override
    @PostMapping("/passenger")
    public void add(@RequestBody Passenger passenger) {
        super.add(passenger);
    }

    @Override
    @GetMapping("/passenger/{id}")
    public Passenger getById(@PathVariable("id") Long id) {
        return super.getById(id);
    }
}
