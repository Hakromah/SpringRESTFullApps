package com.telusko.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/api1")
public class GreetingRestController {

    @GetMapping("/greet")
    @ResponseBody
    public ResponseEntity<String> generateGreetings() {

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

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
