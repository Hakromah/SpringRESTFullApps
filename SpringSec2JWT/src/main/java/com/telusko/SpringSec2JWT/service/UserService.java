package com.telusko.SpringSec2JWT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.SpringSec2JWT.model.User;
import com.telusko.SpringSec2JWT.repo.UserRepo;

@Service
public class UserService 
{
	
	@Autowired
	private UserRepo repo;
	
	public User registerUser(User user)
	{
		
		User us= repo.save(user);
		System.out.println(us +" stored");
		return us;
	}

}
