package com.example.db_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class BoardingPassPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_flight")
    @JsonIgnore
    private Flight flight;
    @ManyToOne
    @JoinColumn(name = "id_passenger")
    @JsonIgnore
    private Passenger passenger;

}
