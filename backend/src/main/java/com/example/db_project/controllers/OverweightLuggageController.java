package com.example.db_project.controllers;

import com.example.db_project.controllers.base.BaseControllerImpl;
import com.example.db_project.entities.OverweightLuggage;
import com.example.db_project.services.OverweightLuggageService;
import com.example.db_project.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OverweightLuggageController extends BaseControllerImpl<OverweightLuggage, Long> {
    @Autowired
    public OverweightLuggageController(OverweightLuggageService service) {
        super(service);
    }

    @Override
    @PostMapping("/overweightluggage")
    public void add(@RequestBody OverweightLuggage overweightLuggage) {
        super.add(overweightLuggage);
    }

    @Override
    @GetMapping("/overweightluggage/{id}")
    public OverweightLuggage getById(@PathVariable("id") Long id) {
        return super.getById(id);
    }
}
