package com.iktex.clients;

import com.iktex.controller.CustomerController;
import com.iktex.models.*;
import com.iktex.utils.EntityManagerUtils;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Objects;

public class InsuranceApiClient {

    public static void main(String[] args) {
        //  CustomerController controller = new CustomerController();

        //if (checkTestData()) persistTestData();
        getSolutionOfN1();
        // getCustomerList(controller);
        //   System.out.println(controller.findCustomer(1));
        // controller.saveCustomer(new Customer("Mustafa", "Yagmur", "Istanbul", 2345678L, "123423242"));
        //  controller.findAllVehicleOfCustomerWithSSID(111111111L).forEach(System.out::println);
    }

    private static void getCustomerList(CustomerController controller) {
        controller.findAllCustomer().forEach(System.out::println);
    }

    private static boolean checkTestData() {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        return Objects.isNull(em.find(Customer.class, 1));
    }

    private static void persistTestData() {
        Address address1 = new Address("Istanbul");
        Address address2 = new Address("Ankara");
        Address address3 = new Address("Izmir");

        Customer customer1 = new Customer("Koray", "Veli", address1, 111111111L, 123423242L);
        Customer customer2 = new Customer("Ayşe", "Turk", address2, 12345678L, 345324523523L);
        Customer customer3 = new Customer("Hasan", "Simsek", address3, 4444444L, 777654643563L);

        customer1.setCreatedDate(LocalDateTime.now());
        customer1.setUpdatedDate(LocalDateTime.now());

        Vehicle car1 = new Car("Hyundai Accent", 2020, "34VG4555", "yellow");
        Vehicle car2 = new Car("Honda Accord", 2018, "34VG111", "black");
        Vehicle moto1 = new MotorCycle("Yamaha", 2015, "06TY555", 222.55);
        Vehicle moto2 = new MotorCycle("Yamakazi", 2018, "35AA555", 145.3);
        Vehicle moto3 = new MotorCycle("Kawasaki", 2022, "01TY355", 250.44);

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

            em.persist(address1);
            em.persist(address2);
            em.persist(address3);

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

    private static void getSolutionOfN1() {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        em.getTransaction().begin();
        TypedQuery<Customer> query = em.createQuery("FROM Customer", Customer.class);
        // TypedQuery<Customer> query = em.createQuery("FROM Customer c join fetch c.vehicleList b join fetch c.address join fetch b.customer", Customer.class);

        // EntityGraph<Customer> entityGraph = em.createEntityGraph(Customer.class);
        // entityGraph.addAttributeNodes("address");
        // entityGraph.addSubgraph("vehicleList").addAttributeNodes("customer");
        // query.setHint("javax.persistence.fetchgraph", entityGraph);

        System.out.println("====== 1 ======");
        List<Customer> customers = query.getResultList();
        System.out.println("====== 2 ======");

     //   for (Customer customer : customers) {
     //       System.out.println("====== 3 ======");
     //       System.out.println(customer.getAddress().getDetail());
     //       System.out.println("====== 4 ======");
//
     //       List<Vehicle> vehicles = customer.getVehicleList();
     //       System.out.println("====== 5 ======");
//
     //       for (Vehicle vehicle : vehicles) {
     //           System.out.println("====== 6 ======");
     //           System.out.println(vehicle.getCustomer().getFirstName());
     //           System.out.println("====== 7 ======");
     //       }
     //   }
     //   System.out.println("====== 8 ======");
        System.out.println(customers.get(0).getVehicleList().get(0).getV_model());


        em.getTransaction().commit();
        EntityManagerUtils.closeEntityManager(em);


    }
}
