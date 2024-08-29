package com.telusko.repository;

import com.telusko.model.HateoasCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<HateoasCourse, Integer> {
}
