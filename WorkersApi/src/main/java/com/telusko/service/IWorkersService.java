package com.telusko.service;

import com.telusko.entity.Workers;

import java.util.List;

public interface IWorkersService {

    public List<Workers> getAllWorkers();

    public Workers saveWorker(Workers worker);

    public Workers getWorkerById(Long id);

    public String updateWorker(Workers worker);

    public String deleteWorker(Long id);
}
