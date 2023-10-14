package com.example.db_project.services;

import com.example.db_project.entities.Employee;
import com.example.db_project.entities.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    Passenger addPassenger(Passenger passenger);
    List<Passenger> addPassengers(List<Passenger> passengers);
    void deletePassenger(Passenger passenger);
    void deletePassengerById(Long id);
    Optional<Passenger> findById(Long id);
    List<Passenger> findAll();
}
