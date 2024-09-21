package com.telusko.service;

import com.telusko.entity.Courses;
import com.telusko.repository.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {

    private final CourseRepo repo;

    public CourseService(CourseRepo repo) {
        this.repo = repo;
    }

    @Override
    public String addCourse(Courses course) {
        repo.save(course);
        return "Data saved successfully";
    }

    @Override
    public Courses getCourse(Integer id) {

        return repo.findById(id).get();
    }

    @Override
    public String updateCourse(Courses course) {
        Courses optional = repo.findById(course.getId()).get();
        optional.setCname(course.getCname());
        optional.setCost(course.getCost());
        optional.setCost(course.getCost());
        repo.save(optional);
        return "Course updated successfully";
    }

    @Override
    public List<Courses> getCourses() {
        return repo.findAll();
    }

    @Override
    public String deleteCourse(Integer id) {
        repo.deleteById(id);
        return "Course deleted successfully";
    }
}
