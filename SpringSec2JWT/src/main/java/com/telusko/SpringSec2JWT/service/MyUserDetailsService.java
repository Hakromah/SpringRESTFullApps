package com.telusko.SpringSec2JWT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.telusko.SpringSec2JWT.model.User;
import com.telusko.SpringSec2JWT.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
	{
		User user=repo.findByName(userName);
		if(user==null)
		{
			System.out.println("User not found 404");
			throw new UsernameNotFoundException("User not found 404");
			
		}
		
		return new UserPrincipal(user);
	}

}
