package com.iktex.clients;

import com.iktex.controller.CustomerController;
import com.iktex.models.*;
import com.iktex.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

public class InsuranceApiClient {
    public static void main(String[] args) {


        if(checkTestData()) persistTestData();
        CustomerController controller = new CustomerController();
        controller.findAllCustomer().forEach(System.out::println);

    }

    private static boolean checkTestData() {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        return Objects.isNull(em.find(Customer.class, 1));
    }

    private static void persistTestData() {
        Customer customer1 = new Customer("Ali", "Veli", "Tuzla Istanbul", 111111111L, "123423242");
        Customer customer2 = new Customer("Ayşe", "Turk", "Baku ", 12345678L, "345324523523");
        Customer customer3 = new Customer("Hasan", "Simsek", "Bostancı Istanbul", 4444444L, "777654643563");

        Vehicle car1 = new Car("Hyundai Accent", 2020, "34VG4555" , "yellow");
        Vehicle car2 = new Car("Honda Accord", 2018, "34VG111" , "black");
        Vehicle moto1 = new MotorCycle("Yamaha", 2015, "06TY555" , 222.55);
        Vehicle moto2 = new MotorCycle("Yamakazi", 2018, "35AA555" , 145.3);
        Vehicle moto3 = new MotorCycle("Kawasaki", 2022, "01TY355" , 250.44);

        car1.setCustomer(customer1);
        car2.setCustomer(customer2);
        moto1.setCustomer(customer1);
        moto2.setCustomer(customer3);
        moto3.setCustomer(customer2);

        Accident accident1 = new Accident(LocalDate.of(2022, Month.APRIL, 22));
        Accident accident2 = new Accident(LocalDate.of(2021, Month.AUGUST, 2));
        Accident accident3 = new Accident(LocalDate.of(2020, Month.JANUARY, 22));

        car1.getAccidentList().add(accident1);
        car2.getAccidentList().add(accident1);
        moto1.getAccidentList().add(accident3);
        moto2.getAccidentList().add(accident1);
        moto3.getAccidentList().add(accident2);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            em.persist(car1);
            em.persist(car2);
            em.persist(moto1);
            em.persist(moto2);
            em.persist(moto3);

            em.persist(customer1);
            em.persist(customer2);
            em.persist(customer3);

            em.persist(accident1);
            em.persist(accident2);
            em.persist(accident3);

            em.getTransaction().commit();
            System.out.println("All data persisted...");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }
}
