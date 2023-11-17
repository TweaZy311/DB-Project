package com.example.db_project.controllers;

import com.example.db_project.controllers.base.BaseControllerImpl;
import com.example.db_project.entities.Department;
import com.example.db_project.services.DepartmentService;
import com.example.db_project.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController extends BaseControllerImpl<Department, Long> {
    @Autowired
    public DepartmentController(DepartmentService service) {
        super(service);
    }

    @Override
    @PostMapping("/department")
    public void add(@RequestBody Department department) {
        super.add(department);
    }

    @Override
    @GetMapping("/department/{id}")
    public Department getById(@PathVariable("id") Long id) {
        return super.getById(id);
    }

//    @Override
//    @PostMapping("/department")
//    public List<Department> addAll(@RequestBody List<Department> departments) {
//        return super.addAll(departments);
//    }
//
//    @Override
//    @DeleteMapping("/department")
//    public void delete(@RequestBody Department department) {
//        super.delete(department);
//    }
//
//    @Override
//    @DeleteMapping("/department")
//    public void deleteById(@RequestParam Long id) {
//        super.deleteById(id);
//    }
//
   @Override
   @GetMapping("/department")
   public List<Department> getAll() {
       return super.getAll();
   }
}
