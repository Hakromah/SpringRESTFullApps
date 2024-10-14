package com.telusko.controller;

import com.telusko.entity.Home;
import com.telusko.service.ResourceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Spring Security App1")
public class ResourceController {

    private ResourceService service;

    public ResourceController(ResourceService service) {
        this.service = service;
    }

    @GetMapping("/gettelusko")
    @Operation(summary = "Get Method", description = "Is to get data from db")
    public List<Home> fetchResources(HttpServletRequest request) {
        System.out.println("Session ID: "+request.getSession().getId());
        return service.getResource();
    }

    @GetMapping("/more")
    @Operation(summary = "Get Method", description = "Is to get more data from db")
    public List<Home> fetchMoreResources(HttpServletRequest request) {
        System.out.println("Session ID: "+request.getSession().getId());
        return service.getResource();
    }

    // === csrfToken configuration ===
    @GetMapping("/csrfToken")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/addtelusko")
    @Operation(summary = "Post Method", description = "Is to add data into db")
    ResponseEntity<Home> addResourceData(@RequestBody Home home) {
        Home status = service.addResource(home);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping("/updatetelusko")
    @Operation(summary = "Put Method", description = "Is to update data from db")
    ResponseEntity<?> updateResource(@RequestBody Home home) {
        String status = service.updateResource(home);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/deletetelusko/{id}")
    @Operation(summary = "Delete Method", description = "Is to delete data from db")
    ResponseEntity<?> deleteResource(@PathVariable("id") Integer id) {
        String status = service.deleteResource(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
