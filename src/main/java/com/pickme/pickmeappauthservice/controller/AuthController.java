package com.pickme.pickmeappauthservice.controller;

import com.pickme.pickmeappauthservice.dtos.*;
import com.pickme.pickmeappauthservice.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;



    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Passenger Signup and SignIn Controllers
    @PostMapping("/signup/passenger")
    public ResponseEntity<PassengerDto> savePassenger(@RequestBody PassengerSignupRequestDto passengerSignupRequestDto){
        return  new ResponseEntity<>(authService.savePassenger(passengerSignupRequestDto), HttpStatus.OK);
    }

    @PostMapping( "/signin/passenger")
    public ResponseEntity<?> signInPassenger(@RequestBody AuthPassengerRequestDto authRequestDto, HttpServletResponse httpServletResponse){
        String result = authService.signInPassenger(authRequestDto,httpServletResponse);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


    //Driver SignUp and SignIn Controllers
    @PostMapping("/signup/driver")
    public ResponseEntity<DriverDto> saveDriver(@RequestBody DriverSignUpRequestDto driverSignUpRequestDto){
        return  new ResponseEntity<>(authService.saveDriver(driverSignUpRequestDto), HttpStatus.OK);
    }

    @PostMapping( "/signin/driver")
    public ResponseEntity<?> signInDriver(@RequestBody AuthPassengerRequestDto authRequestDto, HttpServletResponse httpServletResponse){
        String result = authService.signInDriver(authRequestDto,httpServletResponse);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


    @GetMapping("/validate")
    public ResponseEntity<?> validateUser(HttpServletRequest request){
         return new ResponseEntity<>(Boolean.TRUE,HttpStatus.OK);
    }


}
