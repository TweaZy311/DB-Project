package com.example.db_project.controllers;

import com.example.db_project.controllers.base.BaseControllerImpl;
import com.example.db_project.entities.Department;
import com.example.db_project.entities.Employee;
import com.example.db_project.entities.Person;
import com.example.db_project.entities.Position;
import com.example.db_project.services.EmployeeService;
import com.example.db_project.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController extends BaseControllerImpl<Employee, Long> {
    @Autowired
    public EmployeeController(EmployeeService service) {
        super(service);
    }

    @Override
    @PostMapping("/employee")
    public void add(@RequestBody Employee employee) {
        System.out.println(employee);
        super.add(employee);
    }

    @Override
    @GetMapping("/employee/{id}")
    public Employee getById(@PathVariable("id") Long id) {
        return super.getById(id);
    }

//    @Override
//    @PostMapping("/employee")
//    public List<Employee> addAll(@RequestBody List<Employee> employees) {
//        return super.addAll(employees);
//    }
//
//    @Override
//    @DeleteMapping("/employee")
//    public void delete(@RequestBody Employee employee) {
//        super.delete(employee);
//    }
//
//    @Override
//    @DeleteMapping("/employee")
//    public void deleteById(@RequestParam Long id) {
//        super.deleteById(id);
//    }
//
   @Override
   @GetMapping("/employee")
   public List<Employee> getAll() {
       return super.getAll();
   }
}
