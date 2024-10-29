package com.telusko.service;

import com.telusko.entity.SecuritySchool;
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

    public SecuritySchool addResource(SecuritySchool sSchool) {
        return repo.save(sSchool);
    }

    public List<SecuritySchool> getResource() {
        return repo.findAll();
    }

    public String updateResource(SecuritySchool sSchool) {
        Optional<SecuritySchool> optional = repo.findById(sSchool.getId());
        if (optional.isEmpty()) {
            return "SecuritySchool not found with id: " + sSchool.getId() + " to update";
        } else {
            sSchool.setId(sSchool.getId());
            sSchool.setLocation(sSchool.getLocation());
            sSchool.setHousehold(sSchool.getHousehold());
            repo.save(sSchool);
            return "SecuritySchool updated successfully";
        }
    }

    public String deleteResource(Integer id) {
        Optional<SecuritySchool> optional = repo.findById(id);
        if (optional.isEmpty()) {
            return "SecuritySchool not found with id: " + id + " to delete";
        } else {
            repo.deleteById(id);
            return "SecuritySchool deleted successfully";
        }
    }


}
