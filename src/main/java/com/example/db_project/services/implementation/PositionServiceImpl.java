package com.example.db_project.services.implementation;

import com.example.db_project.entities.Position;
import com.example.db_project.repositories.PositionRepository;
import com.example.db_project.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public Position addPosition(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public List<Position> addPositions(List<Position> positions) {
        return positionRepository.saveAll(positions);
    }

    @Override
    public void deletePosition(Position position) {
        positionRepository.delete(position);
    }

    @Override
    public void deletePositionById(Long id) {
        positionRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public Optional<Position> findById(Long id) {
        return positionRepository.findById(Math.toIntExact(id));
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
