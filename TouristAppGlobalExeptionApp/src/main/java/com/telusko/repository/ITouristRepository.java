package com.telusko.repository;

import com.telusko.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITouristRepository extends JpaRepository<Tourist, Integer> {
}
