package com.telusko.service;

import com.telusko.entity.Role;
import com.telusko.entity.Users;
import com.telusko.repo.RoleRepository;
import com.telusko.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UsersRepo repo;

    @Autowired
    private RoleRepository roleRepo;


    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);


    public Users addUsers(Users user, String roleName) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //fetch the Role from the Database
        Role role = roleRepo.findByRoleName(roleName);
        user.setRoles(Set.of(role));
        return repo.save(user);
    }

    public List<Users> getUsers() {
        return repo.findAll();
    }

    public Users updateUser(Long id, Users user, String roleName) {
        Users existingUser = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the user"));
        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));

        Role role = roleRepo.findByRoleName(roleName);
        existingUser.setRoles(Set.of(role));

        return repo.save(existingUser);
    }

    public String removeUser(Long id) {
        Optional<Users> user = repo.findById(id);
        if (user.isPresent()) {
            repo.deleteById(id);
            return "User deleted successfully";
        } else {
            return "User not found to be deleted";
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Create and return a UserDetails object with the user information
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .roles(user.getRoles().stream().map(Role::getRoleName).toArray(String[]::new))
                .build();
    }
}
