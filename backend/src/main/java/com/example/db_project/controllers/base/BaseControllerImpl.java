package com.example.db_project.controllers.base;

import com.example.db_project.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BaseControllerImpl<Table, Id> implements BaseController<Table, Id>{
    private final BaseService<Table, Id> baseService;

    public BaseControllerImpl(BaseService<Table, Id> baseService) {
        this.baseService = baseService;
    }

    @Override
    public void add(Table table) {
        baseService.add(table);
    }

    @Override
    public Table getById(Id id) {
        return baseService.getById(id);
    }

    @Override
    public List<Table> addAll(List<Table> tables) {
        return baseService.addAll(tables);
    }

    @Override
    public void delete(Table table) {
        baseService.delete(table);
    }

    @Override
    public void deleteById(Id id) {
        baseService.deleteById(id);
    }

    @Override
    public List<Table> getAll() {
        return baseService.getAll();
    }
}
