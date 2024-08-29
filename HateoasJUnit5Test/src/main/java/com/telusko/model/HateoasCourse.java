package com.telusko.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class HateoasCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String author;
    private Double price;

    public HateoasCourse() {
        super();
    }

    public HateoasCourse(String name, String author, Double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

}
