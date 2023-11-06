package com.example.db_project.controllers;

import com.example.db_project.controllers.base.BaseControllerImpl;
import com.example.db_project.entities.Flight;
import com.example.db_project.services.FlightService;
import com.example.db_project.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController extends BaseControllerImpl<Flight, Long> {
    @Autowired
    public FlightController(FlightService service) {
        super(service);
    }

    @Override
    @PostMapping("/flight")
    public void add(@RequestBody Flight flight) {
        System.out.println(flight);
        super.add(flight);
    }

    @Override
    @GetMapping("/flight/{id}")
    public Flight getById(@PathVariable("id") Long id) {
        return super.getById(id);
    }

//    @Override
//    @PostMapping("/flight")
//    public List<Flight> addAll(@RequestBody List<Flight> flights) {
//        return super.addAll(flights);
//    }
//
//    @Override
//    @DeleteMapping("/flight")
//    public void delete(@RequestBody Flight flight) {
//        super.delete(flight);
//    }
//
//    @Override
//    @DeleteMapping("/flight")
//    public void deleteById(@RequestParam Long id) {
//        super.deleteById(id);
//    }
//
//    @Override
//    @GetMapping("/flight")
//    public List<Flight> getAll() {
//        return super.getAll();
//    }
}
