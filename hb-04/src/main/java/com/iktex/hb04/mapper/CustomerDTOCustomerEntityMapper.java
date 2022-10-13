package com.iktex.hb04.mapper;

import com.iktex.hb04.models.CustomerDTO;
import com.iktex.hb04.models.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOCustomerEntityMapper implements BaseMapper<Customer, CustomerDTO> {
    @Override
    public Customer map(CustomerDTO model, Object... params) {
        Customer customer = Customer.builder()
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .address(model.getAddress())
                .phoneNumber(model.getPhoneNumber())
                .build();
        return customer;
    }
}
