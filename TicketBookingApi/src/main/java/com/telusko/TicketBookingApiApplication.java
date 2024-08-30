package com.telusko;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Ticket Booking Api",
                version = "1.0",
                description = "This API is to book a ticket"),
        servers = @Server(
                url = "http://localhost:8787/TicketApi",
                description = "This is the server where our app is deployed"
        ))
public class TicketBookingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketBookingApiApplication.class, args);
    }

}
