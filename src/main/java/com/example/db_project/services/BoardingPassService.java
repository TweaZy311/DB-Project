package com.example.db_project.services;

import com.example.db_project.entities.BoardingPass;

import java.util.List;
import java.util.Optional;

public interface BoardingPassService {
    BoardingPass addBoardingPass(BoardingPass boardingPass);
    List<BoardingPass> addBoardingPasses(List<BoardingPass> boardingPasses);
    void deleteBoardingPass(BoardingPass boardingPass);
    void deleteBoardingPassById(Long id);
    Optional<BoardingPass> findById(Long id);
    List<BoardingPass> findAll();
}
