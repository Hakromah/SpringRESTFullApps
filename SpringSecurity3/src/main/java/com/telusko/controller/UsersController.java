package com.telusko.controller;

import com.telusko.entity.Users;
import com.telusko.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Users Controller")
public class UsersController {

    private final UserService service;

    //private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(12);

    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @PostMapping("/addusers")
    @Operation(summary = "Post Method", description = "Is to add users into the DB")
    ResponseEntity<Users> addUser(@RequestBody Users users,
                                  @Parameter(description = "Role of user")
                                  @RequestParam String role) {
//        String password = users.getPassword();
//        System.out.println("Raw Password: " + password);
//        users.setPassword(bcrypt.encode(password));
//        System.out.println("Encoded Password: " + users.getPassword());
//        //users.setPassword(bcrypt.encode(users.getPassword()));
        Users status = service.addUsers(users, role);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/getusers")
    @Operation(summary = "Get Method", description = "Is to users from the DB")
    ResponseEntity<List<Users>> fetchUsers() {
        List<Users> status = service.getUsers();
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping("/updateusers/{id}")
    @Operation(summary = "Put Method", description = "Is to update users from the DB")
    ResponseEntity<Users> updateUser(
            @PathVariable Long id,
            @RequestBody Users users,
            @Parameter(description = "Role of the user") @RequestParam String role) {
        Users status = service.updateUser(id, users, role);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/deleteusers/{id}")
    @Operation(summary = "Delete Method", description = "Is to delete users from the DB")
    ResponseEntity<String> deleteUser(@PathVariable Long id) {
        String status = service.removeUser(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
