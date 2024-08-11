package com.telusko.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class LunchJackson1 {

    public static void main(String[] args) throws JsonProcessingException {

        Tourist t = new Tourist();
        t.setId(44);
        t.setName("Amara");
        t.setCity("Conakry");

        // this ObjectMapper will convert Java Object to json data
        // that can be sent to client (single objet)

//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(t);
//        System.out.println(json);

        Tourist t2 = new Tourist();
        t2.setId(441);
        t2.setName("Alejandro");
        t2.setCity("London");

        Tourist t3 = new Tourist();
        t3.setId(442);
        t3.setName("Matthiew");
        t3.setCity("Manchester City");

        Tourist t4 = new Tourist();
        t4.setId(443);
        t4.setName("Mohammed");
        t4.setCity("Riad");

        Tourist t5 = new Tourist();
        t5.setId(444);
        t5.setName("Paul");
        t5.setCity("Roma");

        List<Tourist> tList = List.of(t, t2, t3, t4, t5);

        // this ObjectMapper will convert Java Object to json data
        // that can be sent to client (LİST OF OBJECT)
        ObjectMapper mapper1 = new ObjectMapper();
        String list = mapper1.writerWithDefaultPrettyPrinter().writeValueAsString(tList);
        System.out.println(list);

    }
}
