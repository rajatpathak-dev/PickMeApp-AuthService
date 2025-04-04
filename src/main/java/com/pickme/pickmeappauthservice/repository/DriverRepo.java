package com.pickme.pickmeappauthservice.repository;

import com.pickme.pickmeappentityservice.models.Driver;
import com.pickme.pickmeappentityservice.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepo extends JpaRepository<Driver,Long> {
    Optional<Driver> findByEmail(String email);
}
