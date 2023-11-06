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
@Table(name = "overweight_luggage")
public class OverweightLuggage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_luggage")
    @JsonIgnore
    private Luggage luggage;

    @NotNull
    private Integer overweight;
    @NotNull
    @Column(name = "overweight_serchage")
    private Integer overweightSerchage;
}
