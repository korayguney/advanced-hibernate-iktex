package com.iktex.hb04.services;

import com.iktex.hb04.models.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    void findCustomerBySsidAndAddressWithCBTest() {
        // given
        final String address = "Tuzla Istanbul";
        final Long ssid = 111111111L;

        // when
        List<Customer> customers = customerService.findCustomerBySsidAndAddress(ssid, address);

        // then
        assertAll(
                () -> assertNotNull(customers),
                () -> assertEquals(customers.size(), 1)
        );
    }

    @Test
    void findCustomerByPhoneNumberAndAddressCBTest() {
        // given
        final String address = "Tuzla Istanbul";
        final Long phoneNumber = 123423242L;

        // when
        List<Customer> customers = customerService.findCustomerByPhoneNumberAndAddress(phoneNumber, address);

        // then
        assertAll(
                () -> assertNotNull(customers),
                () -> assertEquals(customers.size(), 1)
        );
    }

}
