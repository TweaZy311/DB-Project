package com.example.db_project.controllers;

import com.example.db_project.entities.Employee;
import com.example.db_project.entities.Position;
import com.example.db_project.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        employeeService.addEmployee(employee);
        System.out.println(employee);
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }
}
