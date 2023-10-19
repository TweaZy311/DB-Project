package com.example.db_project.services.implementation;

import com.example.db_project.entities.Flight;
import com.example.db_project.repositories.FlightRepository;
import com.example.db_project.services.FlightService;
import com.example.db_project.services.base.implementation.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl extends BaseServiceImpl<Flight, Long> implements FlightService {
    @Autowired
    public FlightServiceImpl(FlightRepository repository) {
        super(repository);
    }
}
