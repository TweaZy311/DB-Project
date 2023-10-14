package com.example.db_project.services.implementation;

import com.example.db_project.entities.Department;
import com.example.db_project.repositories.DepartmentRepository;
import com.example.db_project.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> addDepartments(List<Department> departments) {
        return departmentRepository.saveAll(departments);
    }

    @Override
    public void deleteDepartment(Department department) {
        departmentRepository.delete(department);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(Math.toIntExact(id));
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
}
