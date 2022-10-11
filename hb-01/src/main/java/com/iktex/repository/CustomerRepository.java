package com.iktex.repository;

import com.iktex.models.Customer;
import com.iktex.models.Vehicle;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer> {
    List<Vehicle> findAllVehicleOfCustomerWithSSID(long ssid);
}
