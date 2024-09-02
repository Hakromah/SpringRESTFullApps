package com.telusko.repository;

import com.telusko.entity.Workers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkersRepo extends JpaRepository<Workers, Long> {
}
