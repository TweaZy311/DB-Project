package com.example.db_project.services.implementation;

import com.example.db_project.entities.Luggage;
import com.example.db_project.repositories.LuggageRepository;
import com.example.db_project.services.LuggageService;
import com.example.db_project.services.base.implementation.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LuggageServiceImpl extends BaseServiceImpl<Luggage, Long> implements LuggageService {
    @Autowired
    public LuggageServiceImpl(LuggageRepository repository) {
        super(repository);
    }
}
