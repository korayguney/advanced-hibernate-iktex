package com.iktex.service;

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

        // then
        assertNotNull(vehicle);
        em.getTransaction().commit();
    }


}
