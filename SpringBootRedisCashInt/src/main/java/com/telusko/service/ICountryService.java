package com.telusko.service;

import com.telusko.model.Country;

import java.util.Collection;

public interface ICountryService {

    String addCountry(Country country);

    Collection<Object> getAllCountries();
}
