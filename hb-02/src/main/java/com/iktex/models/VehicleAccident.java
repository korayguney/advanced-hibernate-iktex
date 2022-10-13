package com.iktex.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class VehicleAccident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private double accidentPrice;

    @OneToMany(mappedBy = "vehicleAccident")
    private List<Vehicle> vehicles = new ArrayList<>();

    @OneToMany(mappedBy = "vehicleAccident")
    private List<Accident> accidents = new ArrayList<>();

    public VehicleAccident(double accidentPrice) {
        this.accidentPrice = accidentPrice;
    }

    public VehicleAccident() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public double getAccidentPrice() {
        return accidentPrice;
    }

    public void setAccidentPrice(double accidentPrice) {
        this.accidentPrice = accidentPrice;
    }
}
