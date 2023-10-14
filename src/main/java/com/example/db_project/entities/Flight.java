package com.example.db_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    @JsonIgnore
    private Employee employee;

    @NotNull
    @Column(name = "departure_point")
    private String departurePoint;
    @NotNull
    private String destination;
    @NotNull
    @Column(name = "departure_time")
    private Date departureTime;
}
