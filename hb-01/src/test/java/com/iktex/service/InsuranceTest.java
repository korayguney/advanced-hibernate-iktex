package com.iktex.service;

import com.iktex.models.Address;
import com.iktex.models.Customer;
import com.iktex.models.Vehicle;
import org.junit.jupiter.api.*;

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
    @Disabled
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
    public void cascadeTest() {
        // given
        Customer customer = new Customer("Mahmut", "Hoca", 3232323L, 342432L);
        Address address = new Address("details test...");
        customer.setAddress(address);

        // when
        em.getTransaction().begin();
        em.persist(address);
        em.persist(customer);
        em.getTransaction().commit();

        // then

    }

}
