package com.iktex.service;

import com.iktex.models.Customer;
import com.iktex.models.Vehicle;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InsuranceTest {

    static EntityManagerFactory emf;
    static EntityManager em;

    @BeforeAll
    public static void setup() {
        emf = Persistence.createEntityManagerFactory("testPU");
    }

    @BeforeEach
    public void setupEach() {
        em = emf.createEntityManager();
    }

    @AfterAll
    public static void destroyEach() {
        emf.close();
    }

    @Test
    void findVehicleTest() {
        // given

        // when
        em.getTransaction().begin();
        Vehicle vehicle = em.find(Vehicle.class, 1L);
        System.out.println("Vehicle found...");
        System.out.println(vehicle.getCustomer().getPhoneNumber());
        // then
        assertNotNull(vehicle);
        em.getTransaction().commit();
    }

    @Test
    void findCustomerTest() {
        // given

        // when
        em.getTransaction().begin();
        Customer customer = em.find(Customer.class, 1);
        System.out.println("customer found...");
        // then
        assertNotNull(customer);
        em.getTransaction().commit();
    }


}
