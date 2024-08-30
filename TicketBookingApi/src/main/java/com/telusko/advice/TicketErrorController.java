package com.telusko.advice;

import com.telusko.exception.TicketBookingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TicketErrorController {

    @ExceptionHandler(TicketBookingException.class)
    ResponseEntity<TicketErrorDetails> handleExceptionForTicket(TicketBookingException bx) {
        TicketErrorDetails state = new TicketErrorDetails("404", bx.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(state, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<TicketErrorDetails> handleExceptionForTicket(Exception tck) {
        TicketErrorDetails state = new TicketErrorDetails("500", tck.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(state, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
