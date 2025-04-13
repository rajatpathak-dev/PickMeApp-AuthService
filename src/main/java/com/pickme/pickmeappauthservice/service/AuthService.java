package com.pickme.pickmeappauthservice.service;

import com.pickme.pickmeappauthservice.dtos.*;
import com.pickme.pickmeappauthservice.repository.DriverRepo;
import com.pickme.pickmeappauthservice.repository.PassengerRepo;
import com.pickme.pickmeappentityservice.models.Driver;
import com.pickme.pickmeappentityservice.models.Passenger;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService{
    private PassengerRepo passengerRepo;

    private DriverRepo driverRepo;
    private PasswordEncoder bCryptPasswordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @Value("${cookie.expiry}")
    private int cookieExpiry;

    public AuthService(PassengerRepo passengerRepo,
                       DriverRepo driverRepo,
                        PasswordEncoder bCryptPasswordEncoder,
                       AuthenticationManager authenticationManager,
                       JwtService jwtService) {
        this.passengerRepo = passengerRepo;
        this.driverRepo = driverRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public PassengerDto savePassenger(PassengerSignupRequestDto passengerSignupRequestDto) {
        Passenger passenger = Passenger.builder()
                              .name(passengerSignupRequestDto.getName())
                              .email(passengerSignupRequestDto.getEmail())
                              .password(bCryptPasswordEncoder.encode( passengerSignupRequestDto.getPassword()))
                              .phoneNo(passengerSignupRequestDto.getPhoneNumber())
                              .build();

        return PassengerDto.convert(passengerRepo.save(passenger));

    }

    public String signInPassenger(AuthPassengerRequestDto authRequestDto, HttpServletResponse httpServletResponse) {
           Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getEmail(), authRequestDto.getPassword()));

           String jwtToken = jwtService.createToken(authRequestDto.getEmail());
           httpServletResponse.setHeader(HttpHeaders.AUTHORIZATION, jwtToken);

           return "success";

    }

    public DriverDto saveDriver(DriverSignUpRequestDto driverSignUpRequestDto) {
        Driver driver = Driver.builder()
                .name(driverSignUpRequestDto.getName())
                .email(driverSignUpRequestDto.getEmail())
                .password(bCryptPasswordEncoder.encode(driverSignUpRequestDto.getPassword()))
                .phoneNo(driverSignUpRequestDto.getPhoneNo())
                .car(driverSignUpRequestDto.getCar())
                .licenseNo(driverSignUpRequestDto.getLicenceNo()).build();

        Driver savedDriver = driverRepo.save(driver);
        savedDriver.getCar().setDriver(savedDriver);

        return DriverDto.convert(driverRepo.save(driver));
    }

    public String signInDriver(AuthPassengerRequestDto authRequestDto, HttpServletResponse httpServletResponse) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getEmail(), authRequestDto.getPassword()));

        String jwtToken = jwtService.createToken(authRequestDto.getEmail());
        httpServletResponse.setHeader(HttpHeaders.AUTHORIZATION, jwtToken);

        return "success";

    }


}
