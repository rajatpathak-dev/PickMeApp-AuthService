package com.pickme.pickmeappauthservice.service;

import com.pickme.pickmeappauthservice.helper.AuthPassengeDetails;
import com.pickme.pickmeappauthservice.repository.DriverRepo;
import com.pickme.pickmeappauthservice.repository.PassengerRepo;
import com.pickme.pickmeappentityservice.models.Driver;
import com.pickme.pickmeappentityservice.models.Passenger;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    PassengerRepo passengerRepo;

    @Autowired
    private DriverRepo driverRepo;





    @Override
    @Cacheable(value = "user",key = "#email")
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Passenger> passengerOptional = passengerRepo.findByEmail(email);
       if(passengerOptional.isPresent()){
           return new AuthPassengeDetails(passengerOptional.get());
       }

       Optional<Driver> driverOptional = driverRepo.findByEmail(email);
       if(driverOptional.isPresent()){
           return new AuthPassengeDetails(driverOptional.get());
       }

       throw new UsernameNotFoundException("Email "+email+" not found");

    }
}
