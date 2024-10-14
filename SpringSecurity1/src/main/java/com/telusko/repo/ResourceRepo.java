package com.telusko.repo;

import com.telusko.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepo extends JpaRepository<Home, Integer> {
}
