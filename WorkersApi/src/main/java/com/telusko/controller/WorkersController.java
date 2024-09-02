package com.telusko.controller;


import com.telusko.entity.Workers;
import com.telusko.service.IWorkersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Tag(name = "WorkersAPI", description = "APIS to manage workers information, CRUD operations")//SWAGGER
public class WorkersController {

    private IWorkersService service;

    @Autowired
    public void setService(IWorkersService service) {
        this.service = service;
    }

    @GetMapping("/fetchAllWorkers")
    ResponseEntity<?> fetchAllWorkers() {
        List<Workers> workers = service.getAllWorkers();
        return new ResponseEntity<List<Workers>>(workers, HttpStatus.OK);
    }

    @GetMapping("/fetchWorkers/{id}")
    @Operation(summary = "GET request", description = "This method will will fetch the worker by id")
    ResponseEntity<?> fetchWorkerById(@PathVariable("id") Long id) {
        Workers workers = service.getWorkerById(id);
        return new ResponseEntity<Workers>(workers, HttpStatus.OK);
    }

    @PostMapping("/saveWorker")
    @Operation(summary = "POST request", description = "This method will accepts worker info and save it in database")
    ResponseEntity<Workers> registerWorker(@RequestBody Workers worker) {
        Workers status = service.saveWorker(worker);
        return new ResponseEntity<Workers>(status, HttpStatus.OK);
    }

    @PutMapping("/worker/{id}")
    @Operation(summary = "PUT request", description = "This method will accepts worker info and update it in database")
    ResponseEntity<Workers> updateWorker(@PathVariable("id") Long id, @RequestBody Workers worker) {
        Workers wkr = service.getWorkerById(id);
        wkr.setName(worker.getName());
        wkr.setEmail(worker.getEmail());
        wkr.setAddress(worker.getAddress());
        wkr.setPhoneNumber(worker.getPhoneNumber());
        wkr.setSpecialization(worker.getSpecialization());
        service.updateWorker(wkr);
        return new ResponseEntity<Workers>(wkr, HttpStatus.OK);
    }

    @DeleteMapping("/deleteWorker/{id}")
    @Operation(summary = "DELETE request", description = "This method will accepts worker id and delete it from database")
    ResponseEntity<Workers> deleteWorker(@PathVariable("id") Long id) {
        service.deleteWorker(id);
        return ResponseEntity.noContent().build();
    }

    //open swagger url: http://localhost:8686/WorkersApi/swagger-ui/index.html
}
