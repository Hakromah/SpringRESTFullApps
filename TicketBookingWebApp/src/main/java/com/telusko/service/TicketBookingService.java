package com.telusko.service;

import com.telusko.model.Passenger;
import com.telusko.model.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;

@Service
public class TicketBookingService implements ITicketBookingService {


    private String BOOKING_URL = "http://localhost:8787/TicketApi/api/book-ticket/getTicketNumber";
    private String GET_URL = "http://localhost:8787/TicketApi/api/book-ticket/getTicket/{ticketNumber}";

    @Override
    public Ticket registerPassenger(Passenger passenger) {

        // We will get all our service logic from a third party api

        //RestTemplate approach
//        RestTemplate template = new RestTemplate();
//        ResponseEntity<Ticket> response = template.postForEntity(BOOKING_URL, passenger, Ticket.class);
//        return response.getBody();

        //Web Client approach (Asynchronous)
        WebClient webClient = WebClient.create();
        Ticket ticket = webClient.post()
                .uri(BOOKING_URL)
                .bodyValue(passenger)
                .retrieve()
                .bodyToMono(Ticket.class)
                .block();
        return ticket;
    }

    @Override
    public Ticket getFullTicketInfo(Integer ticketNumber) {
//        RestTemplate template = new RestTemplate();
//        ResponseEntity<Ticket> response = template.getForEntity(GET_URL, Ticket.class, ticketNumber);
//        return response.getBody();

        //Web Client approach (Asynchronous)
        WebClient webClient = WebClient.create();
        Ticket ticket = webClient.get()
                .uri(GET_URL)
                .retrieve()
                .bodyToMono(Ticket.class)
                .block();
        return ticket;
    }
}
