package com.pickme.pickmeappauthservice.controller;

import com.pickme.pickmeappauthservice.dtos.AuthRequestDto;
import com.pickme.pickmeappauthservice.dtos.PassengerDto;
import com.pickme.pickmeappauthservice.dtos.PassengerSignupRequestDto;
import com.pickme.pickmeappauthservice.service.AuthService;
import com.pickme.pickmeappauthservice.service.JwtService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Value("${cookie.expiry}")
    private int cookieExpiry;

    public AuthController(AuthService authService,AuthenticationManager authenticationManager,JwtService jwtService) {
        this.jwtService = jwtService;
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/signup/passenger")
    public ResponseEntity<PassengerDto> savePassenger(@RequestBody PassengerSignupRequestDto passengerSignupRequestDto){
        return  new ResponseEntity<>(authService.savePassenger(passengerSignupRequestDto), HttpStatus.OK);
    }

    @PostMapping("/signin/passenger")
    public ResponseEntity<?> signInPassenger(@RequestBody AuthRequestDto authRequestDto, HttpServletResponse httpServletResponse){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getEmail(),authRequestDto.getPassword()));
        if(authentication.isAuthenticated()){
             String jwtToken = jwtService.createToken(authRequestDto.getEmail());
            ResponseCookie responseCookie = ResponseCookie.from("jwtToken",jwtToken)
                    .httpOnly(true)
                    .secure(false)
                    .maxAge(cookieExpiry)
                    .path("/")
                    .build();

            httpServletResponse.setHeader(HttpHeaders.SET_COOKIE,responseCookie.toString());
            return new ResponseEntity<>(jwtToken,HttpStatus.OK);
        }
        return new ResponseEntity<>("authenticaion failed",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateUser(HttpServletRequest request){
         Cookie[] cookies =  request.getCookies();
         Cookie tokenCookie = null;
         for(Cookie cookie:cookies){
             if(cookie.getName().equals("jwtToken")){
                 tokenCookie = cookie;
                 break;
             }
         }

         return new ResponseEntity<>(tokenCookie.getValue(),HttpStatus.OK);


    }
}
