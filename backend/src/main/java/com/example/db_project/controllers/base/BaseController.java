package com.example.db_project.controllers.base;


import java.util.List;

public interface BaseController<Table, Id>{
    void add(Table table);
    Table getById(Id id);
    List<Table> addAll(List<Table> tableList);
    void delete(Table table);
    void deleteById(Id id);
    List<Table> getAll();
}
