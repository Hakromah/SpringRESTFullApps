package com.telusko.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)// if unknown data is coming it will ignore it to avoid exception
public class Alien {
    private Integer id;
    private String name;
    private String city;
    private String street;
    private String state;
    private String zip;

    private Course course;
    private String[] friends;

}
