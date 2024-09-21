package com.telusko.repository;

import com.telusko.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Courses, Integer> {
}
