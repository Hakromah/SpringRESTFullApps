package com.telusko.controller;

import com.telusko.entity.Passenger;
import com.telusko.entity.Ticket;
import com.telusko.service.ITicketBookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-ticket")
@Tag(name = "TicketBookingAPIS", description = "APIS to book tickets by passing passenger's information")//SWAGGER
public class TicketBookingController {

    private final ITicketBookingService service;

    @Autowired
    public TicketBookingController(ITicketBookingService service) {
        this.service = service;
    }


    @PostMapping("/getTicketNumber")
    @Operation(summary = "POST request", description = "This method will accepts passenger's info and set passenger id as the ticket number and returns it")
    ResponseEntity<Ticket> registerTicket(@RequestBody Passenger passenger) {
        Passenger pass = service.registerPassenger(passenger);
        Ticket ticket = new Ticket();
        ticket.setTicketNumber(pass.getPid());
        return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
    }

    @GetMapping("/getTicket/{ticketNumber}")
    @Operation(summary = "GET request", description = "This method will accepts ticket number and returns ticket info")
    public ResponseEntity<Ticket> getFullTicketInfo(@PathVariable("ticketNumber") Integer ticketNumber) {

        Passenger passenger = service.fitchPassengerById(ticketNumber);

        Ticket ticket = new Ticket();
        ticket.setTicketNumber(ticketNumber);
        ticket.setName(passenger.getName());
        ticket.setDeparture(passenger.getDeparture());
        ticket.setArrival(passenger.getArrival());
        ticket.setDateOfJourney(passenger.getDateOfJourney());
        ticket.setSeatNo(passenger.getSeatNo());
        ticket.setPnr(passenger.getPnr());
        ticket.setStatus("Confirmed");
        ticket.setTicketCost(550.0);
        return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
    }

    @GetMapping("/getAllPassengers")
    @Operation(summary = "GET request", description = "This method will returns all passengers")
    ResponseEntity<?> getAllTickets() {
        List<Passenger> passengers = service.getAllPassengers();
        return new ResponseEntity<List<Passenger>>(passengers, HttpStatus.OK);
    }
}
