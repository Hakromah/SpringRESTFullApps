package com.telusko.controller;

import com.telusko.entity.Customer;
import com.telusko.service.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Spring CVS Batch App",description = "Customer Processor Rest Controller")
public class CustomerProcessorRestController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private ICustomerService service;

    @Autowired
    private Job job;

    @GetMapping("/import")
    public void loadData() throws Exception {
        JobParameters jobParam = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(job, jobParam);
    }


    @PostMapping("/savecustomer")
    @Operation(summary = "Post method to save customer", description = "This method is used to save customer")
    ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        service.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getcustomers")
    @Operation(summary = "Get method to get all customers", description = "This method is used to fetch all customers")
    ResponseEntity<?> fetchCustomer() {
        List<Customer> status = service.getAllCustomers();
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/deletecustomer/{id}")
    @Operation(summary = "Delete method to delete customer", description = "This method is used to delete a single customer")
    ResponseEntity<?> deleteCustomer(@PathVariable("id") Integer id) {
        service.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updatecustomer/{id}")
    @Operation(summary = "Put method to update customer", description = "This method is used to update a single customer")
    ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable("id") Integer id) {
        Integer optional = customer.getCustomerId();
        if (optional == null) {
            customer.setCustomerId(id);
        }
        service.updateCustomer(customer, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
