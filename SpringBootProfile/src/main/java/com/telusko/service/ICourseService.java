package com.telusko.service;

import com.telusko.entity.Courses;

import java.util.List;

public interface ICourseService {
    String addCourse(Courses course);

    Courses getCourse(Integer id);

    String updateCourse(Courses course);

    List<Courses> getCourses();

    String deleteCourse(Integer id);
}
