package com.example.db_project.services.base.implementation;

import com.example.db_project.services.base.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public class BaseServiceImpl<Table, Id> implements BaseService<Table, Id> {
    private JpaRepository<Table, Id> repository;


    public BaseServiceImpl(JpaRepository<Table, Id> repository) {
        this.repository = repository;
    }

    @Override
    public Table getById(Id id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Table add(Table table) {
        return repository.save(table);
    }

    @Override
    public List<Table> addAll(List<Table> tables) {
        return repository.saveAll(tables);
    }

    @Override
    public void delete(Table table) {
        repository.delete(table);
    }

    @Override
    public void deleteById(Id id) {
        repository.deleteById(id);
    }

    @Override
    public List<Table> getAll() {
        return repository.findAll();
    }
}
