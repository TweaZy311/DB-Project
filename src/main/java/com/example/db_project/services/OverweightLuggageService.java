package com.example.db_project.services;

import com.example.db_project.entities.Employee;
import com.example.db_project.entities.OverweightLuggage;

import java.util.List;
import java.util.Optional;

public interface OverweightLuggageService {
    OverweightLuggage addOverweightLuggage(OverweightLuggage overweightLuggage);
    List<OverweightLuggage> addOverweightLuggages(List<OverweightLuggage> overweightLuggages);
    void deleteOverweightLuggage(OverweightLuggage overweightLuggage);
    void deleteOverweightLuggageById(Long id);
    Optional<OverweightLuggage> findById(Long id);
    List<OverweightLuggage> findAll();
}
