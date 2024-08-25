package com.telusko.controller;

import com.telusko.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class GreetingRestController {

    @Autowired
    private IGreetingService service;

    @GetMapping(value = "/greet")
    @ResponseBody
    public ResponseEntity<String> generateGreetings() {
        String msg = service.generateGreetings();
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
}
