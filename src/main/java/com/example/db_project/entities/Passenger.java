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
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_person")
    @JsonIgnore
    private Person person;
    @ManyToOne
    @JoinColumn(name = "id_passport")
    @JsonIgnore
    private Passport passport;

    @NotNull
    @Column(name = "registration_date")
    private Date registrationDate;
}
