package com.telusko.rest;

import com.telusko.entity.HateoasCourse;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @GetMapping("/getcourse/{id}")
    public ResponseEntity<HateoasCourse> getCourseDetails(@PathVariable("id") Integer id) {

        HateoasCourse course = new HateoasCourse(101, "React", 1000.0);

        // Let add a link here
        Link link = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(CourseController.class)
                        .getJavaCourseInfo()).withRel("linkedcourses");
        course.add(link);
        return new ResponseEntity<HateoasCourse>(course, HttpStatus.OK);
    }

    @GetMapping("/linkedcourses")
    public List<HateoasCourse> getJavaCourseInfo() {
        List<HateoasCourse> courseList = new ArrayList<>();
        courseList.add(new HateoasCourse(1, "Node Js", 1000.0));
        courseList.add(new HateoasCourse(2, "Spring", 2000.0));
        return courseList;
    }

    @GetMapping("/multi")
    public ResponseEntity<HateoasCourse> getAllCourseDetails() {

        HateoasCourse course = new HateoasCourse(101, "React", 1000.0);
        // Let add a link here
        Link link = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(CourseController.class)
                        .getAllCourseInfo()).withRel("multicourses");
        course.add(link);
        return new ResponseEntity<HateoasCourse>(course, HttpStatus.OK);
    }

    @GetMapping("/multicourses")
    public List<HateoasCourse> getAllCourseInfo() {
        List<HateoasCourse> courseList = new ArrayList<>();
        courseList.add(new HateoasCourse(1, "Node Js", 1000.0));
        courseList.add(new HateoasCourse(2, "Spring", 2000.0));
        courseList.add(new HateoasCourse(3, "Java", 3000.0));
        courseList.add(new HateoasCourse(4, "Python", 4000.0));
        courseList.add(new HateoasCourse(5, "C++", 5000.0));
        courseList.add(new HateoasCourse(6, "C#", 6000.0));
        courseList.add(new HateoasCourse(7, "Rust", 7000.0));
        courseList.add(new HateoasCourse(8, "Kotlin", 8000.0));
        return courseList;
    }
}
