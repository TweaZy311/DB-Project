package com.example.db_project.services;

import com.example.db_project.entities.Employee;
import com.example.db_project.entities.Luggage;

import java.util.List;
import java.util.Optional;

public interface LuggageService {
    Luggage addLuggage(Luggage luggage);
    List<Luggage> addLuggages(List<Luggage> luggages);
    void deleteLuggage(Luggage luggage);
    void deleteLuggageById(Long id);
    Optional<Luggage> findById(Long id);
    List<Luggage> findAll();
}
