package com.telusko.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class GenerateGreetingController {

    @GetMapping("/greeting")
    public ResponseEntity<String> generateGreeting() {

        LocalDateTime dateTime = LocalDateTime.now();
        int hour = dateTime.getHour();
        String response = null;
        if (hour < 12)
            response = "Hello! Have a great Morning";
        else if (hour < 16)
            response = "Hello! have a great Evening";
        else if (hour < 20)
            response = "Hello! have a great Noon";
        else
            response = "Hello! have a great Night";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
