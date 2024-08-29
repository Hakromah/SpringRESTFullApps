package com.telusko.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tourist {
    private String name;
    private Integer age;
    private String gender;
    private String country;
    private String city;

//
//    public Tourist(String name, Integer age, String gender, String country, String city) {
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.country = country;
//        this.city = city;
//    }

}
