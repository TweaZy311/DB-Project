package com.example.db_project.services.implementation;

import com.example.db_project.entities.BoardingPass;
import com.example.db_project.repositories.BoardingPassRepository;
import com.example.db_project.services.BoardingPassService;
import com.example.db_project.services.base.implementation.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardingPassServiceImpl extends BaseServiceImpl<BoardingPass, Long> implements BoardingPassService {

    @Autowired
    public BoardingPassServiceImpl(BoardingPassRepository repository) {
        super(repository);
    }
}
