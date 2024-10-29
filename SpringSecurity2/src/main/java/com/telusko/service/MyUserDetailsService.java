package com.telusko.service;

import com.telusko.entity.Users;
import com.telusko.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private  UsersRepo repo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = repo.findByUserName(userName);

        if (user == null) {
            System.out.println("User not found 404");
            throw new UsernameNotFoundException("User not found 404");
        }
        return new UsersPrincipal(user);
    }
}
