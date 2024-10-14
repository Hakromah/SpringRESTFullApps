package com.telusko.service;

import com.telusko.entity.Users;
import com.telusko.repo.UsersRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UsersRepo repo;

    public MyUserDetailsService(UsersRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = repo.findByUserName(userName);

        if (user == null) {
            System.out.println("User not found 404");
            throw new UsernameNotFoundException("User not found 404");
        }
        return new UsersPrincipal(user);
    }

    public List<Users> getUsers() {
        return repo.findAll();
    }

    public String addUsers(Users user) {
        repo.save(user);
        return "user added successfully";
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

    public Users updateUser(String userName, Users user) {
        Users userId = repo.findById(userName).orElse(null);
        if (userId != null) {
            //user.setUserName(user.getUserName());
            user.setPassword(user.getPassword());
            return repo.save(user);
        } else {

            throw new IllegalStateException("User not found with userName: " + userName);
        }
    }
}
