package com.telusko.service;

import com.telusko.entity.Workers;
import com.telusko.exception.WorkersException;
import com.telusko.repository.WorkersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkersService implements IWorkersService {

    private WorkersRepo repo;

    @Autowired
    public void setRepo(WorkersRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Workers> getAllWorkers() {
        return repo.findAll();
    }

    @Override
    public Workers saveWorker(Workers worker) {
        return repo.save(worker);
    }

    @Override
    public Workers getWorkerById(Long id) {
        Optional<Workers> optional = repo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new WorkersException("Worker with id " + id + " not found");
        }
    }

    @Override
    public String updateWorker(Workers worker) {
        Optional<Workers> optional = repo.findById(worker.getId());
        if (optional.isPresent()) {
            repo.save(worker);
            return "Worker with id " + worker.getId() + " updated successfully";
        } else {
            throw new WorkersException("Worker with id " + worker.getId() + " not found to update");
        }
    }

    @Override
    public String deleteWorker(Long id) {
        Optional<Workers> optional = repo.findById(id);
        if (optional.isPresent()) {
            repo.deleteById(id);
            return "Worker with id " + id + " deleted successfully";
        } else {
            throw new WorkersException("Worker with id " + id + " not found to delete");
        }
    }
}
