package com.iktex.controller;

import com.iktex.models.Customer;
import com.iktex.service.CustomerService;

import java.util.List;

public class CustomerController {
    private CustomerService customerService = new CustomerService();

    public List<Customer> findAllCustomer() {
        return customerService.findAll();
    }

    public Customer findCustomer(int id) {
        return customerService.findById(id);
    }

    public void saveCustomer(Customer customer) {
        customerService.saveToDatabase(customer);
    }


}
