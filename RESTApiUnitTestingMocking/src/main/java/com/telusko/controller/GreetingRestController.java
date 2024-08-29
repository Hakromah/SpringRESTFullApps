package com.telusko.controller;

import com.telusko.service.IGreetingService;
import com.telusko.service.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class GreetingRestController {

    @Autowired
    private IGreetingService service;

    @GetMapping(value = "/greet")
    public ResponseEntity<String> generateGreetings() {
        String msg = service.generateGreetings();
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }

    @PostMapping(value = "/addtourist")
    public ResponseEntity<String> addTouristInfo(@RequestBody Tourist tourist) {
        Boolean status = service.acceptTourist(tourist);
        String msg = "";

        if (status) {
            msg = "Tourist information added successfully";
            return new ResponseEntity<String>(msg, HttpStatus.OK);
        } else {
            msg = "Tourist information could not be added";
            return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
