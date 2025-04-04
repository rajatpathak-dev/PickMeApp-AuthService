package com.pickme.pickmeappauthservice.controller_advice;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String>  authenticationFailedExceptionHandler(BadCredentialsException badCredentialsException){
        return new ResponseEntity<>(badCredentialsException.getMessage(), HttpStatus.UNAUTHORIZED);
    }




}
