package com.telusko.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class LunchJackson2 {

    public static void main(String[] args) throws IOException {

        // to covert json to java object

        ObjectMapper mapper = new ObjectMapper();

        // JSON to Java
        Alien alien = mapper.readValue(new File("json/sample-complex.json"), Alien.class);

        Integer id = alien.getId();
        String name = alien.getName();
        String city = alien.getCity();
        Course course = alien.getCourse();
        String[] friends= alien.getFriends();

        System.out.println(id + " :" + name + " : " + city);
        System.out.println(Arrays.toString(friends));


    }
}
