package com.iktex.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate accidentDate;

    @ManyToOne
    private VehicleAccident vehicleAccident;

    public Accident(LocalDate accidentDate) {
        this.accidentDate = accidentDate;
    }

    public Accident() {
    }

    public LocalDate getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(LocalDate accidentDate) {
        this.accidentDate = accidentDate;
    }


    @Override
    public String toString() {
        return "Accident{" +
                "accidentDate=" + accidentDate +
                '}';
    }

    public VehicleAccident getVehicleAccident() {
        return vehicleAccident;
    }

    public void setVehicleAccident(VehicleAccident vehicleAccident) {
        this.vehicleAccident = vehicleAccident;
    }
}
