package com.telusko.repository;

import com.telusko.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Passenger, Integer> {
}
