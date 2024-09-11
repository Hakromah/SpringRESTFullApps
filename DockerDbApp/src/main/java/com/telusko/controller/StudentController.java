package com.telusko.controller;

import com.telusko.entity.Student;
import com.telusko.services.IStudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Student Controller", description = "This project is interacting with Docker DB")
public class StudentController {

    private IStudentService service;

    @Autowired
    public StudentController(IStudentService service) {
        this.service = service;
    }

    @PostMapping("/savestudent")
    @Operation(summary = "Post method to save student", description = "This method is used to save student")
    ResponseEntity<String> saveStudent(@RequestBody Student student) {
        String status = service.saveStudent(student);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/getstudent/{id}")
    @Operation(summary = "Get method to get student", description = "This method is used to fetch a single student")
    ResponseEntity<?> getStudent(@PathVariable("id") Integer id) {
        Student student = service.getStudent(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/getallstudents")
    @Operation(summary = "Get method to get all students", description = "This method is used to fetch all students")
    ResponseEntity<?> getAllStudents() {
        List<Student> students = service.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping("/deletestudent/{id}")
    @Operation(summary = "Delete method to delete student", description = "This method is used to delete a single student")
    ResponseEntity<?> deleteStudent(@PathVariable("id") Integer id) {
        String status = service.deleteStudent(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping("/updatestudent")
    @Operation(summary = "Put method to update student", description = "This method is used to update a single student")
    ResponseEntity<?> updateStudent(@RequestBody Student student) {
        String status = service.updateStudent(student);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping("/updatestudentbyid/{id}")
    @Operation(summary = "Put method to update student by id", description = "This method is used to update a single student by id")
    ResponseEntity<?> updateStudentById(@RequestBody Student student, @PathVariable("id") Integer id) {
        service.updateStudentById(student, id);
        String status = "Student with id: " + id + " updated successfully!";
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
