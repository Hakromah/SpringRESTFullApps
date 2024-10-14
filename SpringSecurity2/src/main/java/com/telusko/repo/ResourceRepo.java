package com.telusko.repo;

import com.telusko.entity.SecuritySchool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepo extends JpaRepository<SecuritySchool, Integer> {
}
