package com.example.db_project.services.implementation;

import com.example.db_project.entities.Position;
import com.example.db_project.repositories.PositionRepository;
import com.example.db_project.services.PositionService;
import com.example.db_project.services.base.implementation.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl extends BaseServiceImpl<Position, Long> implements PositionService {

    @Autowired
    public PositionServiceImpl(PositionRepository repository) {
        super(repository);
    }


}
