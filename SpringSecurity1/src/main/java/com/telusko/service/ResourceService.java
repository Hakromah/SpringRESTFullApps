package com.telusko.service;

import com.telusko.entity.Home;
import com.telusko.repo.ResourceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    private ResourceRepo repo;

    public ResourceService(ResourceRepo repo) {
        this.repo = repo;
    }

    public Home addResource(Home home) {
        return repo.save(home);
    }

    public List<Home> getResource() {
        return repo.findAll();
    }

    public String updateResource(Home home) {
        Optional<Home> optional = repo.findById(home.getId());
        if (optional.isEmpty()) {
            return "Home not found with id: " + home.getId() + " to update";
        } else {
            home.setId(home.getId());
            home.setLocation(home.getLocation());
            home.setHousehold(home.getHousehold());
            repo.save(home);
            return "Home updated successfully";
        }
    }

    public String deleteResource(Integer id) {
        Optional<Home> optional = repo.findById(id);
        if (optional.isEmpty()) {
            return "Home not found with id: " + id + " to delete";
        } else {
            repo.deleteById(id);
            return "Home deleted successfully";
        }
    }


}
