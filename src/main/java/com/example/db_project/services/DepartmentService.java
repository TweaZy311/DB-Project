package com.example.db_project.services;

import com.example.db_project.entities.BoardingPass;
import com.example.db_project.entities.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department addDepartment(Department department);
    List<Department> addDepartments(List<Department> departments);
    void deleteDepartment(Department department);
    void deleteDepartmentById(Long id);
    Optional<Department> findById(Long id);
    List<Department> findAll();
}
