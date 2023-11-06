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
@Table(name = "boarding_pass")
public class BoardingPass {

    @EmbeddedId
    private BoardingPassPK id;

    public BoardingPass(BoardingPassPK id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "seat_number")
    private Integer seatNumber;

}
