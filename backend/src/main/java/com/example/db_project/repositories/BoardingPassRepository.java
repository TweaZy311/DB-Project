package com.example.db_project.repositories;

import com.example.db_project.entities.BoardingPass;
import com.example.db_project.entities.BoardingPassPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardingPassRepository extends JpaRepository<BoardingPass, BoardingPassPK> {
}
