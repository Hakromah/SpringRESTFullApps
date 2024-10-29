package com.telusko.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "myUsers")
@Entity
public class Users {

    @Id
    private String userName;

    private String password;

}
