package com.example.db_project.services;

import com.example.db_project.entities.Department;
import com.example.db_project.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> addEmployees(List<Employee> employees);
    void deleteEmployee(Employee employee);
    void deleteEmployeeById(Long id);
    Optional<Employee> findById(Long id);
    List<Employee> findAll();
}
