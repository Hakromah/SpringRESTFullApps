package com.telusko.service;

import com.telusko.model.Country;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class CountryService implements ICountryService {

    private final HashOperations<String, Object, Object> opsForHas;

//    @Autowired
//    RedisTemplate<String, Country> redis;
    public CountryService(RedisTemplate<String, Country> redis) {
        this.opsForHas = redis.opsForHash();
    }


    @Override
    public String addCountry(Country country) {
        opsForHas.put("COUNTRIES", country.getCtNo(), country);
        return "Country Info added to Redis Server";
    }

    @Override
    public Collection<Object> getAllCountries() {
        Map<Object, Object> entries = opsForHas.entries("COUNTRIES");
        Collection<Object> countries = entries.values();
        return countries;
    }
}
