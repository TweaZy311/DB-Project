package com.example.db_project.services.implementation;

import com.example.db_project.entities.Passport;
import com.example.db_project.repositories.PassportRepository;
import com.example.db_project.services.PassportService;
import com.example.db_project.services.base.implementation.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassportServiceImpl extends BaseServiceImpl<Passport, Long> implements PassportService {
    @Autowired
    public PassportServiceImpl(PassportRepository repository) {
        super(repository);
    }

}
