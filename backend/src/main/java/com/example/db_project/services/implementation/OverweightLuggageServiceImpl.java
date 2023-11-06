package com.example.db_project.services.implementation;

import com.example.db_project.entities.OverweightLuggage;
import com.example.db_project.repositories.OverweightLuggageRepository;
import com.example.db_project.services.OverweightLuggageService;
import com.example.db_project.services.base.implementation.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OverweightLuggageServiceImpl extends BaseServiceImpl<OverweightLuggage, Long> implements OverweightLuggageService {

    @Autowired
    public OverweightLuggageServiceImpl(OverweightLuggageRepository repository) {
        super(repository);
    }
}
