package com.iktex.hb04.configs;

import com.iktex.hb04.models.entity.*;
import com.iktex.hb04.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class TestDataConfigurer implements CommandLineRunner {

    //private static final Logger logger = Logger.getLogger("TestDataConfigurer");

    @PersistenceContext
    EntityManager entityManager;

    private final CustomerRepository customerRepository;
    private final AccidentRepository accidentRepository;
    private final VehicleRepository vehicleRepository;
    private final CarRepository carRepository;
    private final MotorcycleRepository motorcycleRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        if (!isDataExists()) {

            // prepare entities ( in transient state)
            Customer customer1 = new Customer("Koray", "Veli", "Tuzla Istanbul", 111111111L, 123423242L);
            Customer customer2 = new Customer("Ayşe", "Turk", "Baku ", 12345678L, 345324523523L);
            Customer customer3 = new Customer("Hasan", "Simsek", "Bostancı Istanbul", 4444444L, 777654643563L);
            Customer customer4 = new Customer("Test", "Test", "Bostancı Istanbul", 4444444L, 777654643563L);

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

            car1.getAccident().add(accident1);
            car2.getAccident().add(accident1);
            moto1.getAccident().add(accident3);
            moto2.getAccident().add(accident1);
            moto3.getAccident().add(accident2);

            // persist entities ( in persisted state)
            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);

            vehicleRepository.save(car1);
            vehicleRepository.save(car2);
            vehicleRepository.save(moto1);
            vehicleRepository.save(moto2);
            vehicleRepository.save(moto3);

            accidentRepository.save(accident1);
            accidentRepository.save(accident2);
            accidentRepository.save(accident3);

            entityManager.persist(customer4);

            log.info("All data saved....");
        }

    }

    private boolean isDataExists() {
        return customerRepository.count() > 0 ? Boolean.TRUE : Boolean.FALSE;
    }
}
