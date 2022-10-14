package com.iktex.hb04.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedQuery(name = "Customer.findByName", query = "FROM Customer WHERE firstName = ?1")
@NamedNativeQuery(name = "Customer.findByNameNative", query = "SELECT * FROM customer WHERE first_name = ?", resultClass = Customer.class)
@NamedStoredProcedureQuery(name = "Customer.findByNameSP",
        procedureName = "GetCustomerDataByName",
        parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "custName")})
public class Customer extends AbstractBaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private Long ssid;
    private long phoneNumber;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private List<Vehicle> vehicleList = new ArrayList<>();

    public Customer(String firstName, String lastName, String address, Long ssid, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.ssid = ssid;
        this.phoneNumber = phoneNumber;
    }
}
