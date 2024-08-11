package com.telusko.service;

import com.telusko.model.Tourist;

import java.util.List;

public interface ITouristService {

    String registerTourist(Tourist tourist);

    Tourist fetchTouristById(Integer id);

    List<Tourist> fetchAllTourist();

    String updateTouristData(Tourist tourist);

    String updateTouristDataById(Integer id, Double budget);

    String deleteTouristById(Integer id);
}
