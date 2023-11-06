package com.example.db_project.services.implementation;

import com.example.db_project.entities.Department;
import com.example.db_project.repositories.DepartmentRepository;
import com.example.db_project.services.DepartmentService;
import com.example.db_project.services.base.implementation.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department, Long> implements DepartmentService {
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository repository) {
        super(repository);
    }
}
