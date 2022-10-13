package com.iktex.clients;

import com.iktex.controller.CustomerController;
import com.iktex.models.*;
import com.iktex.utils.SessionUtil;
import org.hibernate.Session;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

public class InsuranceApiClient {

    public static void main(String[] args) {
        CustomerController controller = new CustomerController();


        //if (checkTestData())
         persistTestData();
        // getCustomerList(controller);
        //System.out.println(controller.findCustomer(1));
       // controller.saveCustomer(new Customer("Mustafa", "Yagmur", "Istanbul", 2345678L, "123423242"));
        System.out.println("********** TEST *************");
       // controller.findAllVehicleOfCustomerWithSSID(111111111L).forEach(System.out::println);
    }

    private static void getCustomerList(CustomerController controller) {
        controller.findAllCustomer().forEach(System.out::println);
    }

    private static boolean checkTestData() {
        Session session = SessionUtil.getSession();
        return Objects.isNull(session.find(Customer.class, 1));
    }

    private static void persistTestData() {
        Customer customer1 = new Customer("Ali", "Veli", "Tuzla Istanbul", 111111111L, "123423242");
        Customer customer2 = new Customer("Ayşe", "Turk", "Baku ", 12345678L, "345324523523");
        Customer customer3 = new Customer("Hasan", "Simsek", "Bostancı Istanbul", 4444444L, "777654643563");

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

        VehicleAccident vehicleAccident1 = new VehicleAccident(2500.45);
        VehicleAccident vehicleAccident2 = new VehicleAccident(135.54);
        VehicleAccident vehicleAccident3 = new VehicleAccident(2220.33);

        accident1.setVehicleAccident(vehicleAccident1);
        accident2.setVehicleAccident(vehicleAccident2);
        accident3.setVehicleAccident(vehicleAccident3);

        car1.setVehicleAccident(vehicleAccident1);
        car2.setVehicleAccident(vehicleAccident1);
        moto1.setVehicleAccident(vehicleAccident2);
        moto1.setVehicleAccident(vehicleAccident3);

       //car1.getAccidentList().add(accident1);
       //car2.getAccidentList().add(accident1);
       //moto1.getAccidentList().add(accident3);
       //moto2.getAccidentList().add(accident1);
       //moto3.getAccidentList().add(accident2);

        Session session = SessionUtil.getSession();

        try {
            session.getTransaction().begin();

            session.persist(car1);
            session.persist(car2);
            session.persist(moto1);
            session.persist(moto2);
            session.persist(moto3);

            session.persist(customer1);
            session.persist(customer2);
            session.persist(customer3);

            session.persist(accident1);
            session.persist(accident2);
            session.persist(accident3);

            session.persist(vehicleAccident1);
            session.persist(vehicleAccident2);
            session.persist(vehicleAccident3);


            session.getTransaction().commit();
            System.out.println("All data persisted...");
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
