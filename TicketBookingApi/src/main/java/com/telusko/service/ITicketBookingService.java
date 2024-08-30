package com.telusko.service;

import com.telusko.entity.Passenger;

import java.util.List;

public interface ITicketBookingService {

    public Passenger registerPassenger(Passenger passenger);

    public Passenger fitchPassengerById(Integer id);
    List<Passenger> getAllPassengers();
}
