package com.telusko.advice;

import com.telusko.exception.WorkersException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class WorkersErrorController {

    @ExceptionHandler(WorkersException.class)
    ResponseEntity<WorkersErrorDetails> handleExceptionForWorkers(WorkersException bx) {
        WorkersErrorDetails state = new WorkersErrorDetails("404", bx.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(state, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<WorkersErrorDetails> handleExceptionForWorkers(Exception bx) {
        WorkersErrorDetails state = new WorkersErrorDetails("500", bx.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(state, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
