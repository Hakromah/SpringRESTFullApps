package com.telusko.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Workers")
public class Workers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "ADDR")
    private String address;

    @Column(name = "PHN")
    private String phoneNumber;

    @Column(name = "SPC")
    private String specialization;

    public Workers() {
        super();
    }

    public Workers(String specialization, String phoneNumber, String address, String email, String name) {
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Workers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
