package com.example.db_project.services;

import com.example.db_project.entities.Employee;
import com.example.db_project.entities.Position;

import java.util.List;
import java.util.Optional;

public interface PositionService {
    Position addPosition(Position position);
    List<Position> addPositions(List<Position> positions);
    void deletePosition(Position position);
    void deletePositionById(Long id);
    Optional<Position> findById(Long id);
    List<Position> findAll();
}
