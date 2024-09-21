package com.telusko.controller;

import com.telusko.entity.Courses;
import com.telusko.service.ICourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Course Controller", description = "Course Controller")
public class CourseController {

    private ICourseService service;

    public CourseController(ICourseService service) {
        this.service = service;
    }

    @PostMapping("/addcourse")
    @Operation(summary = "Post method", description = "is to add data to the database")
    ResponseEntity<?> saveCourse(@RequestBody Courses course) {
        String status = service.addCourse(course);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @PutMapping("/updatecourse")
    @Operation(summary = "Put Method", description = "Is to update the data")
    ResponseEntity<?> updateCourse(@RequestBody Courses course) {
        String status = service.updateCourse(course);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/getcourses")
    @Operation(summary = "Get method", description = "Is to fetch all the records from the database ")
    ResponseEntity<?> getCourses() {
        List<Courses> courses = service.getCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @DeleteMapping("/deletecourse/{id}")
    @Operation(summary = "Delete method", description = "Is to delete the records from the db")
    ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        String status = service.deleteCourse(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/getcourse/{id}")
    @Operation(summary = "Get metho", description = "Is to fetch the data by providing it Id")
    ResponseEntity<?> getCourse(@PathVariable Integer id) {
        Courses course = service.getCourse(id);
        return new ResponseEntity<>(course, HttpStatus.OK);

    }
    //http://localhost:8585/profileApp/swagger-ui/index.html
}
