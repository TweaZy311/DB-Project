package com.example.db_project.services.implementation;

import com.example.db_project.entities.Employee;
import com.example.db_project.repositories.EmployeeRepository;
import com.example.db_project.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> addEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(Math.toIntExact(id));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
