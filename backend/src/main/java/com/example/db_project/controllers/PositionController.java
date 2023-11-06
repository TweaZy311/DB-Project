package com.example.db_project.controllers;

import com.example.db_project.controllers.base.BaseControllerImpl;
import com.example.db_project.entities.Position;
import com.example.db_project.services.PositionService;
import com.example.db_project.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PositionController extends BaseControllerImpl<Position, Long> {
    @Autowired
    public PositionController(PositionService service) {
        super(service);
    }

    @Override
    @PostMapping("/position")
    public void add(@RequestBody Position position) {
        super.add(position);
    }

    @Override
    @GetMapping("/position/{id}")
    public Position getById(@PathVariable("id") Long id) {
        return super.getById(id);
    }
}
