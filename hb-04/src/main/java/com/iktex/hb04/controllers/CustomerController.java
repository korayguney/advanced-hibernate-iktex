package com.iktex.hb04.controllers;

import com.iktex.hb04.models.CustomerDTO;
import com.iktex.hb04.models.entity.Customer;
import com.iktex.hb04.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
       return customerService.getAllCustomers();
    }


    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable("id") int id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("/customers")
    public int getCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.saveCustomer(customerDTO);
    }

}
