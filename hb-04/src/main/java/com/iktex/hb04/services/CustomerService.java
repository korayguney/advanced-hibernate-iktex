package com.iktex.hb04.services;

import com.iktex.hb04.mapper.CustomerDTOCustomerEntityMapper;
import com.iktex.hb04.models.CustomerDTO;
import com.iktex.hb04.models.entity.Customer;
import com.iktex.hb04.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDTOCustomerEntityMapper customerDTOCustomerEntityMapper;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(int id) {
        return customerRepository.findById(id).get();
    }

    public int saveCustomer(CustomerDTO customerDTO) {
        Customer customer = customerDTOCustomerEntityMapper.map(customerDTO);
        return customerRepository.save(customer).getId();
    }

}
