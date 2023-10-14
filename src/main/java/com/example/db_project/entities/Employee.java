package com.example.db_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_person")
    @NotNull
    private Person person;

    @ManyToOne
    @JoinColumn(name = "id_department")
    @NotNull
    private Department department;

    @ManyToOne
    @JoinColumn(name = "id_position")
    @NotNull
    private Position position;

    @NotNull
    private Integer salary;


}
