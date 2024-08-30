package com.telusko.service;

import com.telusko.model.Passenger;
import com.telusko.model.Ticket;

public interface ITicketBookingService {

    public Ticket registerPassenger(Passenger passenger);
    public Ticket getFullTicketInfo(Integer ticketNumber);
}
