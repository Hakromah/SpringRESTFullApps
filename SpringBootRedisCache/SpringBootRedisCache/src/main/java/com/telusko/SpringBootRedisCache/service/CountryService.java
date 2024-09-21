package com.telusko.SpringBootRedisCache.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.telusko.SpringBootRedisCache.model.Country;

@Service
public class CountryService 
{
     private HashOperations<String, Object, Object> opsForHash=null;

//	@Autowired
//	private RedisTemplate<String, Country> redis;
	
	public CountryService(RedisTemplate<String, Country> redis)
	{
		this.opsForHash=redis.opsForHash();
		
	}
	
	public String addCountry(Country country)
	{
		opsForHash.put("COUNTRIES", country.getNo(), country);
		return "Country Info added to Redis Service";
	}
	
	public Collection<Object> getAllCountries()
	{
		Map<Object, Object> entries = opsForHash.entries("COUNTRIES");
		Collection<Object> countries = entries.values();
		return countries;
	}

}
