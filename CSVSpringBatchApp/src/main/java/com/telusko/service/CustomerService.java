package com.telusko.service;

import com.telusko.entity.Customer;
import com.telusko.repo.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository repo;

    @Override
    public String saveCustomer(Customer customer) {
        repo.save(customer);
        return "Customer with id " + customer.getCustomerId() + " saved successfully";
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    @Override
    public String deleteCustomerById(Integer id) {
        repo.deleteById(id);
        return "Customer with id " + id + " deleted successfully";
    }

    @Override
    public String updateCustomer(Customer customer, Integer id) {
        Optional<Customer> optional = repo.findById(customer.getCustomerId());
        if (!optional.isPresent()) {
            return "Customer with id " + id + " not found";
        } else if (!optional.get().getCustomerId().equals(id)) {
            customer.setCustomerId(id);
        }
        repo.save(customer);
        return "Customer with id " + customer.getCustomerId() + " updated successfully";
    }
}
