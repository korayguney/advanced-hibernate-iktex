package com.iktex.service;

import com.iktex.models.Vehicle;
import org.hibernate.Session;
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

    @Test
    void findVehicleTest() {
        em.getTransaction().begin();
        Session session = em.unwrap(Session.class);
        //Vehicle vehicle = session.byNaturalId(Vehicle.class).using("v_plate", "34VG4555").load();
        Vehicle vehicle = session.bySimpleNaturalId(Vehicle.class).load("34VG4555");

        assertNotNull(vehicle);
        assertEquals(vehicle.getV_plate(), "34VG4555");
        em.getTransaction().commit();
    }

}
