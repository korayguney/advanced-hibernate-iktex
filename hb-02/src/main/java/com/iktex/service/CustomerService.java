package com.iktex.service;

import com.iktex.models.Customer;
import com.iktex.models.Vehicle;
import com.iktex.repository.CustomerRepository;
import com.iktex.utils.SessionUtil;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerService implements CustomerRepository {

    Session session = SessionUtil.getSession();

    @Override
    public List<Customer> findAll() {
        // JPQL & HQL
        return session.createQuery("FROM Customer", Customer.class).getResultList();
    }

    @Override
    public Customer findById(int id) {
        return session.find(Customer.class, id);
    }

    @Override
    public void saveToDatabase(Customer customer) {
        try {
            session.getTransaction().begin();
            session.persist(customer);
            session.getTransaction().commit();
            System.out.println("Customer saved...");
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteFromDatabase(Customer object) {

    }

    @Override
    public void deleteFromDatabase(int id) {

    }

    @Override
    public void updateOnDatabase(Customer object) {

    }

    @Override
    public List<Vehicle> findAllVehicleOfCustomerWithSSID(long ssid) {
        TypedQuery<Customer> q =  session.createQuery("FROM Customer c WHERE c.ssid = :ssid", Customer.class);
        q.setParameter("ssid", ssid);
        Customer customer = q.getSingleResult(); // Lazy loading
        return customer.getVehicleList();
    }
}
