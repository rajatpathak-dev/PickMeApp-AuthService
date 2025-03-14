package com.pickme.pickmeappauthservice.repository;

import com.pickme.pickmeappauthservice.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger,Long>{

}
