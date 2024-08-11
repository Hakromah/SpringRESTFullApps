package com.telusko.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class AlienRestController {

    @GetMapping("/getAlien")
    public ResponseEntity<Alien> getAlienInfo() {

        Alien alien = new Alien(101, "Hassan", "Monrovia");
        return new ResponseEntity<Alien>(alien, HttpStatus.OK);
    }
}
