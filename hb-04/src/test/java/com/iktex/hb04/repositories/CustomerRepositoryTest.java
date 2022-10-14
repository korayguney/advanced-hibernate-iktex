package com.iktex.hb04.repositories;

import com.iktex.hb04.models.entity.Customer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;


    @Autowired
    EntityManager em;

    @Test
    void findAllByFirstNameTest() {
        // given
        final String firstname = "Hasan";

        // when
        List<Customer> customers = customerRepository.findAllByFirstName(firstname);

        // then
        assertNotNull(customers);
    }

    @Test
    void findAllCustomersByFirstNameTest() {
        // given
        final String firstname = "Hasan";

        // when
        List<Customer> customers = customerRepository.findAllCustomersByFirstName(firstname);

        // then
        assertNotNull(customers);
    }

    @Test
    void findAllCustomersByFirstNameWithEntityManagerTest() {
        // given
        final String firstname = "Hasan";

        // when
        List<Customer> customers = em.createQuery("FROM Customer c WHERE c.firstName =:fname")
                .setParameter("fname", firstname)
                .getResultList();

        // then
        assertAll(
                () -> assertNotNull(customers),
                () -> assertTrue(customers.size() > 0)
        );
    }


    @Test
    void updateCustomerBySsidTest() {
        // given
        final String address = "Kadıköy Istanbul";
        final Long ssid = 12345678L;

        // when
        customerRepository.updateCustomerBySsid(address, ssid);
        Customer customer = customerRepository.findCustomerBySsid(ssid);

        // then
        assertAll(
                () -> assertNotNull(customer),
                () -> assertEquals(customer.getAddress(), address)
        );
    }

    @Test
    void findAllCustomersByFirstNameWithEntityManagerNamedQueryTest() {
        // given
        final String firstname = "Hasan";

        // when
        List<Customer> customers = em.createNamedQuery("Customer.findByName")
                .setParameter(1, firstname)
                .getResultList();

        // then
        assertAll(
                () -> assertNotNull(customers),
                () -> assertTrue(customers.size() > 0)
        );
    }

    @Test
    @Disabled
    void findAllCustomersByFirstNameWithEntityManagerNamedNativeQueryTest() {
        // given
        final String firstname = "Hasan";

        // when
        List<Customer> customers = em.createNativeQuery("Customer.findByNameNative")
                .setParameter(1, firstname)
                .getResultList();

        // then
        assertAll(
                () -> assertNotNull(customers),
                () -> assertTrue(customers.size() > 0)
        );
    }

    @Test
    void findAllCustomersByFirstNameWithStoredProcedureTest() {
        // given
        final String firstname = "Haydar";

        // when
        List<Customer> customers = em.createNamedStoredProcedureQuery("Customer.findByNameSP")
                .setParameter("custName", firstname)
                .getResultList();

        // then
        assertAll(
                () -> assertNotNull(customers)
        );
    }

}