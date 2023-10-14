package com.example.db_project.controllers;

import com.example.db_project.entities.Department;
import com.example.db_project.entities.Position;
import com.example.db_project.services.DepartmentService;
import com.example.db_project.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PositionController {
    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping("/position")
    public void addPosition(@RequestBody Position position) {
        positionService.addPosition(position);
    }

    @GetMapping("/position/{id}")
    public Optional<Position> getPositionById(@PathVariable("id") Long id) {
        return positionService.findById(id);
    }
}
