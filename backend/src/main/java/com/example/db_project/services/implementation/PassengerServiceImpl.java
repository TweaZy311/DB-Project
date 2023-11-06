package com.example.db_project.services.implementation;

import com.example.db_project.entities.Passenger;
import com.example.db_project.repositories.PassengerRepository;
import com.example.db_project.services.PassengerService;
import com.example.db_project.services.base.implementation.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl extends BaseServiceImpl<Passenger, Long> implements PassengerService {
    @Autowired
    public PassengerServiceImpl(PassengerRepository repository) {
        super(repository);
    }
}
