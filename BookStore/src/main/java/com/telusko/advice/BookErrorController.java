package com.telusko.advice;

import com.telusko.exception.BookStoreException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class BookErrorController {

    @ExceptionHandler(BookStoreException.class)
    ResponseEntity<BookErrorDetails> handleExceptionForBook(BookStoreException bx) {
        BookErrorDetails state = new BookErrorDetails("404", bx.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(state, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<BookErrorDetails> handleExceptionForBook(Exception bx) {
        BookErrorDetails state = new BookErrorDetails("500", bx.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(state, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
