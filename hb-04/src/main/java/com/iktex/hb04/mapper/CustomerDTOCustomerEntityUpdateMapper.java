package com.iktex.hb04.mapper;

import com.iktex.hb04.models.CustomerDTO;
import com.iktex.hb04.models.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOCustomerEntityUpdateMapper implements BaseMapper<Customer, CustomerDTO> {
    @Override
    public Customer map(CustomerDTO model, Object... params) {
        Customer customer = (Customer) params[0];
        customer.setFirstName(model.getFirstName());
        customer.setLastName(model.getLastName());
        customer.setAddress(model.getAddress());
        customer.setPhoneNumber(model.getPhoneNumber());
        customer.setSsid(model.getSsid());
        return customer;
    }
}
