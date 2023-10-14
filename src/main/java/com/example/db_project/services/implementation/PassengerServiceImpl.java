package com.example.db_project.services.implementation;

import com.example.db_project.entities.Passenger;
import com.example.db_project.repositories.PassengerRepository;
import com.example.db_project.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public List<Passenger> addPassengers(List<Passenger> passengers) {
        return passengerRepository.saveAll(passengers);
    }

    @Override
    public void deletePassenger(Passenger passenger) {
        passengerRepository.delete(passenger);
    }

    @Override
    public void deletePassengerById(Long id) {
        passengerRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public Optional<Passenger> findById(Long id) {
        return passengerRepository.findById(Math.toIntExact(id));
    }

    @Override
    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }
}
