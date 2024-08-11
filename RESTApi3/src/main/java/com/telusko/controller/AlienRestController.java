package com.telusko.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlienRestController {

    @PostMapping("/addalien")
    public ResponseEntity<String> addAlienInfo(@RequestBody Alien alien) {

        String body = "Alien data added";
        System.out.println(alien);
        return new ResponseEntity<String>(body, HttpStatus.OK);
    }
}
