package com.example.db_project.services.implementation;

import com.example.db_project.entities.BoardingPass;
import com.example.db_project.repositories.BoardingPassRepository;
import com.example.db_project.services.BoardingPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardingPassServiceImpl implements BoardingPassService {
    private final BoardingPassRepository boardingPassRepository;

    @Autowired
    public BoardingPassServiceImpl(BoardingPassRepository boardingPassRepository) {
        this.boardingPassRepository = boardingPassRepository;
    }

    @Override
    public BoardingPass addBoardingPass(BoardingPass boardingPass) {
        return boardingPassRepository.save(boardingPass);
    }

    @Override
    public List<BoardingPass> addBoardingPasses(List<BoardingPass> boardingPasses) {
        return boardingPassRepository.saveAll(boardingPasses);
    }

    @Override
    public void deleteBoardingPassById(Long id) {
        boardingPassRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public void deleteBoardingPass(BoardingPass boardingPass) {
        boardingPassRepository.delete(boardingPass);
    }

    @Override
    public Optional<BoardingPass> findById(Long id) {
        return boardingPassRepository.findById(Math.toIntExact(id));
    }

    @Override
    public List<BoardingPass> findAll() {
        return boardingPassRepository.findAll();
    }
}
