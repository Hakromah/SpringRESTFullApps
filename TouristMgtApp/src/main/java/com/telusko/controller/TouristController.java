package com.telusko.controller;

import com.telusko.exceptions.TouristNotFoundException;
import com.telusko.model.Tourist;
import com.telusko.service.ITouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TouristController {

    private final ITouristService service;

    @Autowired
    public TouristController(ITouristService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<String> addTouristInfo(@RequestBody Tourist tourist) {
        try {
            String status = service.registerTourist(tourist);
            return new ResponseEntity<String>(status, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Some problem in registration", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getalltourist")
    public ResponseEntity<?> getTouristInfo() {
        try {
            List<Tourist> status = service.fetchAllTourist();
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Some problem fetching records", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getTourist/{id}")
    public ResponseEntity<?> getTouristInfoById(@PathVariable("id") Integer id) {

        try {
            Tourist tourist = service.fetchTouristById(id);
            return new ResponseEntity<>(tourist, HttpStatus.OK);

        } catch (TouristNotFoundException t) {
            return new ResponseEntity<String>(t.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/updateTourist")
    public ResponseEntity<?> updateTouristInfo(@RequestBody Tourist tourist) {

        try {
            String status = service.updateTouristData(tourist);
            return new ResponseEntity<>(status, HttpStatus.OK);

        } catch (TouristNotFoundException t) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateInfo/{id}/{budget}")
    public ResponseEntity<?> updateTouristInfo(@PathVariable("id") Integer id, @PathVariable("budget") Double budget) {

        try {
            String status = service.updateTouristDataById(id, budget);
            return new ResponseEntity<>(status, HttpStatus.OK);

        } catch (TouristNotFoundException t) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTouristInfo(@PathVariable("id") Integer id) {
        String status = service.deleteTouristById(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
