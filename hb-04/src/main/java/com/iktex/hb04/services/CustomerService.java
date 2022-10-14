package com.iktex.hb04.services;

import com.iktex.hb04.mapper.CustomerDTOCustomerEntityMapper;
import com.iktex.hb04.mapper.CustomerDTOCustomerEntityUpdateMapper;
import com.iktex.hb04.models.CustomerDTO;
import com.iktex.hb04.models.entity.Customer;
import com.iktex.hb04.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDTOCustomerEntityMapper customerDTOCustomerEntityMapper;
    private final CustomerDTOCustomerEntityUpdateMapper customerDTOCustomerEntityUpdateMapper;

    @PersistenceContext
    EntityManager em;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(int id) {
        return customerRepository.findById(id).get();
    }

    public int saveCustomer(CustomerDTO customerDTO) {
        Customer customer = customerDTOCustomerEntityMapper.map(customerDTO);
        return customerRepository.save(customer).getId();
    }

    @Transactional
    public boolean updateCustomer(CustomerDTO customerDTO, int id) {
        Customer customer = customerRepository.findById(id).get();
        customer = customerDTOCustomerEntityUpdateMapper.map(customerDTO, customer);
        return Objects.nonNull(customerRepository.save(customer));
    }

    @Transactional
    public boolean deleteCustomer(int id) {
        try {
            customerRepository.deleteById(id);
            return !customerRepository.existsById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

    // _______________ //
    //  CriteriaBuilder//
    // _______________ //
    public List<Customer> findCustomerBySsidAndAddress(Long ssid, String address) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);

        Root<Customer> customer = cq.from(Customer.class);
        Predicate ssidPredicate = cb.equal(customer.get("ssid"), ssid);
        Predicate addressPredicate = cb.like(customer.get("address"), "%" + address + "%");
        cq.where(ssidPredicate, addressPredicate);

        TypedQuery<Customer> query = em.createQuery(cq);
        return query.getResultList();
    }

    public List<Customer> findCustomerByPhoneNumberAndAddress(Long phonenumber, String address) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);

        Root<Customer> customer = cq.from(Customer.class);
        List<Predicate> predicates = new ArrayList<>();

        if(Objects.nonNull(phonenumber)) {
           predicates.add(cb.equal(customer.get("phoneNumber"), phonenumber));
        }
        if(Objects.nonNull(address)) {
            predicates.add(cb.like(customer.get("address"), "%" + address + "%"));
        }
        cq.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Customer> query = em.createQuery(cq);
        return query.getResultList();
    }


}
