package com.example.db_project.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String name;
    @Column(name = "second_name")
    @NotNull
    private String secondName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    @NotNull
    private LocalDate dateOfBirth;
}
