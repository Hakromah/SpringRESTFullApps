package com.telusko.service;

import com.telusko.entity.Users;
import com.telusko.repo.UsersRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UsersRepo repo;

    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(12);

    public UserService(UsersRepo repo) {
        this.repo = repo;
    }

    public List<Users> getUsers() {
        return repo.findAll();
    }

    public Users addUsers(Users user) {
        return repo.save(user);
    }

    public String removeUser(String userName) {
        Optional<Users> user = repo.findById(userName);
        if (user.isPresent()) {
            repo.deleteById(userName);
            return "User deleted successfully";
        } else {
            return "User not found to be deleted";
        }
    }

    //    public Users updateUser(String userName, Users user) {
//        Users userId = repo.findById(userName).orElse(null);
//        if (userId != null) {
//            //user.setUserName(user.getUserName());
//            user.setPassword(user.getPassword());
//            return repo.save(user);
//        } else {
//
//            throw new IllegalStateException("User not found with userName: " + userName);
//        }
//    }
    public Users updateUser(String userName, Users user) {
        Users existingUser = repo.findById(userName).orElse(null);
        if (existingUser != null) {
            if (!user.getPassword().equals(existingUser.getPassword())) {
                // Encode only if the password has changed and is in plain text
                existingUser.setPassword(bcrypt.encode(user.getPassword()));
            }
            return repo.save(existingUser);
        } else {
            throw new IllegalStateException("User not found with userName: " + userName);
        }
    }

}
