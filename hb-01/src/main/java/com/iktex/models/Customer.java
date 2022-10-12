package com.iktex.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private Long ssid;
   // @Column(name = "pnumber", columnDefinition = "VARCHAR(100) NOT NULL")
    @Basic(fetch = FetchType.LAZY)
    private long phoneNumber;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "customer")
    private List<Vehicle> vehicleList = new ArrayList<>();

    public Customer(String firstName, String lastName, Address address, Long ssid, long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.ssid = ssid;
        this.phoneNumber = phoneNumber;
    }

    public Customer(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getSsid() {
        return ssid;
    }

    public void setSsid(Long ssid) {
        this.ssid = ssid;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return ssid != null ? ssid.equals(customer.ssid) : customer.ssid == null;
    }

    @Override
    public int hashCode() {
        return ssid != null ? ssid.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", ssid=" + ssid +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
