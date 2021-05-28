package com.gracie.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ParkingExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handle(ParkingException e)
    {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
