package com.example.db_project.services.implementation;

import com.example.db_project.entities.Luggage;
import com.example.db_project.repositories.LuggageRepository;
import com.example.db_project.services.LuggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LuggageServiceImpl implements LuggageService {
    private final LuggageRepository luggageRepository;

    @Autowired
    public LuggageServiceImpl(LuggageRepository luggageRepository) {
        this.luggageRepository = luggageRepository;
    }

    @Override
    public Luggage addLuggage(Luggage luggage) {
        return luggageRepository.save(luggage);
    }

    @Override
    public List<Luggage> addLuggages(List<Luggage> luggages) {
        return luggageRepository.saveAll(luggages);
    }

    @Override
    public void deleteLuggage(Luggage luggage) {
        luggageRepository.delete(luggage);
    }

    @Override
    public void deleteLuggageById(Long id) {
        luggageRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public Optional<Luggage> findById(Long id) {
        return luggageRepository.findById(Math.toIntExact(id));
    }

    @Override
    public List<Luggage> findAll() {
        return luggageRepository.findAll();
    }
}
