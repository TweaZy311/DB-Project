package com.example.db_project.controllers;

import com.example.db_project.controllers.base.BaseControllerImpl;
import com.example.db_project.entities.Luggage;
import com.example.db_project.services.LuggageService;
import com.example.db_project.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LuggageController extends BaseControllerImpl<Luggage, Long> {
    @Autowired
    public LuggageController(LuggageService service) {
        super(service);
    }

    @Override
    @PostMapping("/luggage")
    public void add(@RequestBody Luggage luggage) {
        super.add(luggage);
    }

    @Override
    @GetMapping("/luggage/{id}")
    public Luggage getById(@PathVariable("id") Long id) {
        return super.getById(id);
    }

//    @Override
//    public List<Luggage> addAll(List<Luggage> luggages) {
//        return super.addAll(luggages);
//    }
//
//    @Override
//    public void delete(Luggage luggage) {
//        super.delete(luggage);
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//        super.deleteById(aLong);
//    }

    @Override
    @GetMapping("/luggage")
    public List<Luggage> getAll() {
        return super.getAll();
    }
}
