package com.telusko.service;

import com.telusko.model.HateoasCourse;
import com.telusko.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseServices {


    private CourseRepository repo;

    @Autowired
    public void setRepo(CourseRepository repo) {
        this.repo = repo;
    }

    @Override
    public String registerCourse(HateoasCourse hateoasCourse) {
        repo.save(hateoasCourse);
        return "Course registered successfully ";
    }

    @Override
    public String updateCourse(HateoasCourse hateoasCourse) {
        Optional<HateoasCourse> optional = repo.findById(hateoasCourse.getId());
        if (optional.isPresent()) {
            repo.save(hateoasCourse);
            return "Course updated successfully ";
        } else {
            return "Course not found to be updated";
        }
    }

    @Override
    public String updateCourseById(Integer id, Double budget) {
        Optional<HateoasCourse> optional = repo.findById(id);
        if (optional.isPresent()) {
            HateoasCourse hateoasCourse = optional.get();
            hateoasCourse.setPrice(budget);
            repo.save(hateoasCourse);
            return "Course updated successfully ";
        }
        return new RuntimeException("Course not found to be updated").getMessage();
    }

    @Override
    public String deleteCourseById(Integer id) {
        Optional<HateoasCourse> optional = repo.findById(id);
        if (optional.isPresent()) {
            repo.deleteById(id);
            return "Course deleted successfully";
        } else {
            return "Course not found with id++" + id + " to be deleted";
        }
    }

    @Override
    public HateoasCourse fetchCourseById(Integer id) {
        Optional<HateoasCourse> optional = repo.findById(id);
        return optional.orElseThrow(() -> new RuntimeException("Course not found with id " + id));
    }

    @Override
    public List<HateoasCourse> findAllCourse() {
        return repo.findAll();
    }
}
