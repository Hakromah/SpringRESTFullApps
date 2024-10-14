package com.telusko.controller;

import com.telusko.model.Student;
import com.telusko.service.KafkaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Student Controller")
public class StudentController {


    private KafkaService service;

    public StudentController(KafkaService service) {
        this.service = service;
    }

    @Operation(summary = "Post Method", description = "Is to Add message to Kafka topic")
    @PostMapping("/addMessage")
    ResponseEntity<?> addStudentMessage(@RequestBody Student student) {
        String status = service.sendMessage(student);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

//    @Operation(summary = "Get Method", description = "Is to get message from Kafka topic")
//    @GetMapping("/receiveMessage")
//    ResponseEntity<Student> receiveMessage() {
//        return new ResponseEntity<>(service.receiveMessage(), HttpStatus.OK);
//    }
}
