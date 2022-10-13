package com.iktex.service;

import com.iktex.models.Address;
import com.iktex.models.Customer;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class InsuranceTest {

    static EntityManagerFactory emf;
    static EntityManager em;

    @BeforeAll
    public static void setup() {
        emf = Persistence.createEntityManagerFactory("mysqlPU");
    }

    @BeforeEach
    public void setupEach() {
        em = emf.createEntityManager();
    }

    @AfterAll
    public static void destroyEach() {
        emf.close();
    }

    //@Test
    //void findVehicleTest() {
    //    // given

    //    // when
    //    em.getTransaction().begin();
    //    Vehicle vehicle = em.find(Vehicle.class, 1L);

    //    // then
    //    assertNotNull(vehicle);
    //    em.getTransaction().commit();
    //}

    @Test
    void updateCustomerEntityTest() {
        try {
            em.getTransaction().begin();
            Customer customer = em.find(Customer.class, 1);
            customer.setUpdatedDate(LocalDateTime.now());
            em.merge(customer);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    @Test
    public  void orphanRemovalTest() {
        em.getTransaction().begin();

        Address address = new Address("new Test address");

        Customer customer = em.find(Customer.class, 1);
        customer.setAddress(address);
        em.persist(address);
        em.merge(customer);

        em.getTransaction().commit();

        Address address1 = em.find(Address.class, 1);
        assertNull(address1);
    }

    @Test
    void loadGetDifferenceTest() {
        em.getTransaction().begin();
        Session session = em.unwrap(Session.class);
        Address address = new Address("new Test address");

        Customer customer = session.load(Customer.class, 1);
        address.setCustomer(customer);
        em.persist(address);
        //em.merge(customer);
        em.getTransaction().commit();
    }

    @Test
    void findGetReferenceDifferenceTest() {
        em.getTransaction().begin();
        Address address = new Address("new Test address");

        Customer customer = em.getReference(Customer.class, 1);
        address.setCustomer(customer);
        em.persist(address);
        //em.merge(customer);
        em.getTransaction().commit();
    }

}
