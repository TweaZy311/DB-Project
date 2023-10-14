package com.example.db_project.services;

import com.example.db_project.entities.Employee;
import com.example.db_project.entities.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    Flight addFlight(Flight flight);
    List<Flight> addFlights(List<Flight> flights);
    void deleteFlight(Flight flight);
    void deleteFlightById(Long id);
    Optional<Flight> findById(Long id);
    List<Flight> findAll();
}
