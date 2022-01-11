package com.example.authserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class MasterExceptionHandler {
    /*
    This is a handler for Global Exception
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> defaultException(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, new Date(), ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
