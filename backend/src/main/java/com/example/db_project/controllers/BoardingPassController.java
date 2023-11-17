package com.example.db_project.controllers;


import com.example.db_project.controllers.base.BaseControllerImpl;
import com.example.db_project.entities.BoardingPass;
import com.example.db_project.entities.BoardingPassPK;
import com.example.db_project.entities.Flight;
import com.example.db_project.entities.Passenger;
import com.example.db_project.services.BoardingPassService;
import com.example.db_project.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardingPassController extends BaseControllerImpl<BoardingPass, BoardingPassPK> {

    @Autowired
    public BoardingPassController(BoardingPassService service) {
        super(service);
    }

    @Override
    @PostMapping("/boardingpass")
    public void add(@RequestBody BoardingPass boardingPass) {
        System.out.println(boardingPass);
        super.add(boardingPass);
    }

    @GetMapping("/boardingpass/{id_passenger}/{id_flight}")
    public BoardingPass getById(@PathVariable("id_passenger") Long id_passenger,
                                @PathVariable("id_flight") Long id_flight) {
        return super.getById(new BoardingPassPK(new Flight(id_flight), new Passenger(id_passenger)));
    }

    @Override
    @PostMapping("/boardingpasses")
    public List<BoardingPass> addAll(@RequestBody List<BoardingPass> boardingPasses) {
        return super.addAll(boardingPasses);
    }

    @Override
    @DeleteMapping("/boardingpass")
    public void delete(@RequestBody BoardingPass boardingPass) {
        super.delete(boardingPass);
    }

//    @Override
//    @DeleteMapping("/boardingpass")
//    public void deleteById(@RequestParam BoardingPassPK id) {
//        super.deleteById(id);
//    }

    @Override
    @GetMapping("/boardingpass")
    public List<BoardingPass> getAll() {
        return super.getAll();
    }
}
