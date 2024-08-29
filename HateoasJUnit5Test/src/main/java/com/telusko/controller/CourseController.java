package com.telusko.controller;

import com.telusko.model.HateoasCourse;
import com.telusko.service.ICourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cApi")
public class CourseController {


    private ICourseServices services;

    @Autowired
    public void setServices(ICourseServices services) {
        this.services = services;
    }

    @PostMapping("/saveCourse")
    public ResponseEntity<String> saveCourse(HateoasCourse hateoasCourse) {
        String status = services.registerCourse(hateoasCourse);
        return new ResponseEntity<String>(status, HttpStatus.CREATED);
    }

    @PutMapping("/updateCourse")
    public ResponseEntity<?> updateCourse(@RequestBody HateoasCourse hateoasCourse) {
        String status = services.updateCourse(hateoasCourse);
        return new ResponseEntity<String>(status, HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateCourse/{id}/{budget}")
    public ResponseEntity<?> updateCourseById(@PathVariable("id") Integer id, @PathVariable("budget") Double budget) {
        String status = services.updateCourseById(id, budget);
        return new ResponseEntity<String>(status, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteCourse")
    public ResponseEntity<?> removeCourseById(Integer id) {
        String status = services.deleteCourseById(id);
        return new ResponseEntity<String>(status, HttpStatus.ACCEPTED);
    }

    @GetMapping("/fetchCourse/{id}")
    public ResponseEntity<HateoasCourse> getCourseById(@PathVariable("id") Integer id) {
        HateoasCourse hateoasCourse = services.fetchCourseById(id);
        return new ResponseEntity<HateoasCourse>(hateoasCourse, HttpStatus.OK);
    }

    @GetMapping("/findAllCourse")
    public ResponseEntity<?> getAllCourses() {
        List<HateoasCourse> course = services.findAllCourse();
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
}
