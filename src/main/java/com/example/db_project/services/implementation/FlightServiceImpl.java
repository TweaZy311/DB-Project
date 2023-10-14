package com.example.db_project.services.implementation;

import com.example.db_project.entities.Flight;
import com.example.db_project.repositories.FlightRepository;
import com.example.db_project.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> addFlights(List<Flight> flights) {
        return flightRepository.saveAll(flights);
    }

    @Override
    public void deleteFlight(Flight flight) {
        flightRepository.delete(flight);
    }

    @Override
    public void deleteFlightById(Long id) {
        flightRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public Optional<Flight> findById(Long id) {
        return flightRepository.findById(Math.toIntExact(id));
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }
}
