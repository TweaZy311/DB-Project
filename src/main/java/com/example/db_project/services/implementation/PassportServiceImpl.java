package com.example.db_project.services.implementation;

import com.example.db_project.entities.Passport;
import com.example.db_project.repositories.PassportRepository;
import com.example.db_project.services.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;

    @Autowired
    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public Passport addPassport(Passport passport) {
        return passportRepository.save(passport);
    }

    @Override
    public List<Passport> addPassport(List<Passport> passports) {
        return passportRepository.saveAll(passports);
    }

    @Override
    public void deletePassport(Passport passport) {
        passportRepository.delete(passport);
    }

    @Override
    public void deletePassportById(Long id) {
        passportRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public Optional<Passport> findById(Long id) {
        return passportRepository.findById(Math.toIntExact(id));
    }

    @Override
    public List<Passport> findAll() {
        return passportRepository.findAll();
    }
}
