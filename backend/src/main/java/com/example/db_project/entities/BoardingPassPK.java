package com.example.db_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class BoardingPassPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_flight")
    public Flight flight;
    @ManyToOne
    @JoinColumn(name = "id_passenger")
    public Passenger passenger;

}
