package com.example.db_project.repositories;

import com.example.db_project.entities.OverweightLuggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OverweightLuggageRepository extends JpaRepository<OverweightLuggage, Long> {
}
