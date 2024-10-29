package com.telusko.SpringSec2JWT.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.SpringSec2JWT.model.User;

public interface UserRepo extends JpaRepository<User, String> {
	
	User findByName(String userName);

}
