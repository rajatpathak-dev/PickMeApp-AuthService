package com.pickme.pickmeappauthservice.service;

import com.pickme.pickmeappauthservice.dtos.PassengerDto;
import com.pickme.pickmeappauthservice.dtos.PassengerSignupRequestDto;
import com.pickme.pickmeappauthservice.repository.PassengerRepo;
import com.pickme.pickmeappentityservice.models.Passenger;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService{
    private PassengerRepo passengerRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public PassengerDto savePassenger(PassengerSignupRequestDto passengerSignupRequestDto) {
        Passenger passenger = Passenger.builder()
                              .name(passengerSignupRequestDto.getName())
                              .email(passengerSignupRequestDto.getEmail())
                              .password(bCryptPasswordEncoder.encode( passengerSignupRequestDto.getPassword()))
                              .phoneNo(passengerSignupRequestDto.getPhoneNumber())
                              .build();

        return PassengerDto.convert(passengerRepo.save(passenger));

    }
}
