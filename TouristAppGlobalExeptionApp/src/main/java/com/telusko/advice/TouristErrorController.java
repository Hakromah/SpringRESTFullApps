package com.telusko.advice;


import com.telusko.exceptions.TouristNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TouristErrorController {

    @ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleExceptionForTourist(TouristNotFoundException tn) {

        ErrorDetails er = new ErrorDetails("404", tn.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleExceptionGlobally(Exception e) {

        ErrorDetails er = new ErrorDetails("500", e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(er, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
