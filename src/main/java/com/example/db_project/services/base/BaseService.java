package com.example.db_project.services.base;

import java.util.List;

public interface BaseService <Table, Id>{
    Table getById(Id id);
    Table add(Table table);
    List<Table> addAll(List<Table> tableList);
    void delete(Table table);
    void deleteById(Id id);
    List<Table> getAll();
}
