package com.telusko.controller;

import com.telusko.model.Student;
import com.telusko.service.KafkaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {


    private KafkaService service;

    public StudentController(KafkaService service) {
        this.service = service;
    }

    @PostMapping("/addMessage")
    ResponseEntity<?> addStudentMessage(@RequestBody Student student) {
        String status = service.sendMessage(student);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
