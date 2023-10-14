package com.example.db_project.services;

import com.example.db_project.entities.Employee;
import com.example.db_project.entities.Passport;

import java.util.List;
import java.util.Optional;

public interface PassportService {
    Passport addPassport(Passport passport);
    List<Passport> addPassport(List<Passport> passports);
    void deletePassport(Passport passport);
    void deletePassportById(Long id);
    Optional<Passport> findById(Long id);
    List<Passport> findAll();
}
