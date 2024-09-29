package com.telusko.repository;

import com.telusko.model.Country;
import com.telusko.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@Tag(name = "RedisCache Application", description = "This App is to connect our Spring Boot App to Redis Cache Temporary Memory")
public class CountryRestController {

    @Autowired
    private CountryService service;

    @PostMapping("/savecountry")
    @Operation(summary = "Post method",description = "This is to add new data to Redis Cache Memory")
    ResponseEntity<?> saveCountry(@RequestBody Country country) {
        String status = service.addCountry(country);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/getcountries")
    @Operation(summary = "Get Method",description = "Is to fetch all the data from the RedisCache Memory")
    ResponseEntity<Object> fetchAllCountry() {
        Collection<Object> status = service.getAllCountries();
        return new ResponseEntity<Object>( status, HttpStatus.OK);
    }

}
