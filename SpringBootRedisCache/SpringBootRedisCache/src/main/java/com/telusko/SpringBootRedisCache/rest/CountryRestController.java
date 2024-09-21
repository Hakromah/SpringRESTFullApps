package com.telusko.SpringBootRedisCache.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.SpringBootRedisCache.model.Country;
import com.telusko.SpringBootRedisCache.service.CountryService;

@RestController
public class CountryRestController 
{
	@Autowired
	private CountryService service;
	
	@PostMapping("/add")
	public String addCountry(@RequestBody Country country)
	{
		return service.addCountry(country);
	}
	
	@GetMapping("/getcountries")
	public Collection getCountries()
	{
		return service.getAllCountries();
	}

}
