package com.telusko.service;

import com.telusko.entity.Passenger;
import com.telusko.exception.TicketBookingException;
import com.telusko.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketBookingService implements ITicketBookingService {

    private TicketRepository repo;

    @Autowired
    public void setRepo(TicketRepository repo) {
        this.repo = repo;
    }

    @Override
    public Passenger registerPassenger(Passenger passenger) {
        return repo.save(passenger);
    }

    @Override
    public Passenger fitchPassengerById(Integer id) {
        Optional<Passenger> optional = repo.findById(id);
        return optional.orElseThrow(() -> new TicketBookingException("Passenger with id " + id + " not found"));
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return repo.findAll();
    }
}
