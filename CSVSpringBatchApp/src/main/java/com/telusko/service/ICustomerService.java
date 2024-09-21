package com.telusko.service;

import com.telusko.entity.Customer;

import java.util.List;

public interface ICustomerService {

    String saveCustomer(Customer customer);

    Customer getCustomerById(Integer id);

    List<Customer> getAllCustomers();

    String deleteCustomerById(Integer id);

    String updateCustomer(Customer customer, Integer id);

}
