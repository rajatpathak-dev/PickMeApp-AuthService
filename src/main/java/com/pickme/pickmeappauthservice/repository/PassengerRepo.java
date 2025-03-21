package com.pickme.pickmeappauthservice.repository;


import com.pickme.pickmeappentityservice.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger,Long>{

    Optional<Passenger> findByEmail(String email);
}
