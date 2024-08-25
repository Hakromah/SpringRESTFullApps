package com.telusko.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GreetingService implements IGreetingService {

    @Override
    public String generateGreetings() {

        LocalDateTime dateTime = LocalDateTime.now();
        int hour = dateTime.getHour();
        String response = null;

        if (hour < 12)
            response = "Hello!  have a great morning";
        else if (hour < 16)
            response = "Hello! Have a great noon";
        else if (hour < 20)
            response = "Hello  Have a great evening";
        else
            response = "Hello! Have a great night";

        return response;
    }
}
