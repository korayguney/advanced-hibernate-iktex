package com.iktex.hb04.repositories;

import com.iktex.hb04.models.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByFirstName(String firstName);

    @Query("FROM Customer c WHERE c.firstName =:fname")
    List<Customer> findAllCustomersByFirstName(@Param("fname") String firstName);

    @Transactional
    @Query("UPDATE Customer c SET c.address =:address WHERE c.ssid =:ssid")
    @Modifying
    void updateCustomerBySsid(String address, Long ssid);

    Customer findCustomerBySsid(Long ssid);
}
