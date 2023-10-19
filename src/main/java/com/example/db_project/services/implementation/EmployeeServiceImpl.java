package com.example.db_project.services.implementation;

import com.example.db_project.entities.Employee;
import com.example.db_project.repositories.EmployeeRepository;
import com.example.db_project.services.EmployeeService;
import com.example.db_project.services.base.implementation.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee, Long> implements EmployeeService {
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }
}
