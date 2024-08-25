package com.telusko.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CourseController {
    // @PostMapping(value = "/addcourse",consumes = "application/json") IT WAS USED IN OLD VERSION
    @PostMapping(value = "/addcourse")
    public ResponseEntity<String> addCourseDetails(@RequestBody Course course) {
        System.out.println(course);
        String msg = "Course added successfully";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    // @GetMapping(value = "/getcourse", produces = "application/json") IT WAS USED IN OLD VERSION
    @GetMapping(value = "/getcourse")
    public ResponseEntity<Course> getCourseDetails() {
        Course course = new Course(101, "JSBM", 2000.0, "9 months");
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }
}
