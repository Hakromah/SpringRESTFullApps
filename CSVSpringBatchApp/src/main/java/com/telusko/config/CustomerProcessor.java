package com.telusko.config;

import com.telusko.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer item) throws Exception {
        //logic to process item or filter the data
        return item;
    }
}
