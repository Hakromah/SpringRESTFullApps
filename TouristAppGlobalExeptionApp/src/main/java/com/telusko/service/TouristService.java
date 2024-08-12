package com.telusko.service;

import com.telusko.exceptions.TouristNotFoundException;
import com.telusko.model.Tourist;
import com.telusko.repository.ITouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService implements ITouristService {

    private final ITouristRepository repo;

    @Autowired
    public TouristService(ITouristRepository repo) {
        this.repo = repo;
    }

    @Override
    public String registerTourist(Tourist tourist) {
        Tourist touristDb = repo.save(tourist);
        return "Tourist added successfully with Id: " + touristDb.getId();
    }

    @Override
    public Tourist fetchTouristById(Integer id) {

        //        Optional<Tourist> optional = repo.findById(id);
//        if (optional.isPresent()){
//            return optional.get();
//        }
//        return null;
        return repo.findById(id).orElseThrow(() -> new TouristNotFoundException("No data found with Id: " + id));
    }

    @Override
    public List<Tourist> fetchAllTourist() {
        return repo.findAll();
    }

    @Override
    public String updateTouristData(Tourist tourist) {

        Optional<Tourist> optional = repo.findById(tourist.getId());
        if (optional.isPresent()) {
            repo.save(tourist);
            return "Tourist info with id " + tourist.getId() + " updated";
        } else {

            throw new TouristNotFoundException("Tourist with Id :" + tourist.getId() + " is not present in the records to update");
        }
    }

    @Override
    public String updateTouristDataById(Integer id, Double budget) {

        Optional<Tourist> optional = repo.findById(id);
        if (optional.isPresent()) {
            Tourist tourist = optional.get();
            tourist.setBudget(budget);
            repo.save(tourist);
            return "Tourist with Id: " + id + " updated";
        } else {

            throw new RuntimeException("server issue");
        }
    }

    @Override
    public String deleteTouristById(Integer id) {
        Optional<Tourist> optional = repo.findById(id);
        if (optional.isPresent()) {
            repo.deleteById(id);
            return "Tourist with Id: " + id + " deleted";
        } else {
            throw new TouristNotFoundException("Tourist with id: " + id + " is not found to delete");
        }
    }
}
