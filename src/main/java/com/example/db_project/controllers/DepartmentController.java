package com.example.db_project.controllers;

import com.example.db_project.entities.Department;
import com.example.db_project.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/department")
    public void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }

    @GetMapping("/department/{id}")
    public Optional<Department> getDepartmentById(@PathVariable("id") Long id){
        return departmentService.findById(id);
    }
}
