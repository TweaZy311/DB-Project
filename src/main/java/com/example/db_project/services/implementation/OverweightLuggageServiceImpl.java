package com.example.db_project.services.implementation;

import com.example.db_project.entities.OverweightLuggage;
import com.example.db_project.repositories.OverweightLuggageRepository;
import com.example.db_project.services.OverweightLuggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OverweightLuggageServiceImpl implements OverweightLuggageService {
    private final OverweightLuggageRepository overweightLuggageRepository;

    @Autowired
    public OverweightLuggageServiceImpl(OverweightLuggageRepository overweightLuggageRepository) {
        this.overweightLuggageRepository = overweightLuggageRepository;
    }

    @Override
    public OverweightLuggage addOverweightLuggage(OverweightLuggage overweightLuggage) {
        return overweightLuggageRepository.save(overweightLuggage);
    }

    @Override
    public List<OverweightLuggage> addOverweightLuggages(List<OverweightLuggage> overweightLuggages) {
        return overweightLuggageRepository.saveAll(overweightLuggages);
    }

    @Override
    public void deleteOverweightLuggage(OverweightLuggage overweightLuggage) {
        overweightLuggageRepository.delete(overweightLuggage);
    }

    @Override
    public void deleteOverweightLuggageById(Long id) {
        overweightLuggageRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public Optional<OverweightLuggage> findById(Long id) {
        return overweightLuggageRepository.findById(Math.toIntExact(id));
    }

    @Override
    public List<OverweightLuggage> findAll() {
        return overweightLuggageRepository.findAll();
    }
}
