package com.iktex.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class MotorCycle extends Vehicle {
    private double enginePower;

    public MotorCycle(String v_model, int v_year, String v_plate, double enginePower) {
        super(v_model, v_year, v_plate);
        this.enginePower = enginePower;
    }

    public MotorCycle(double enginePower) {
        this.enginePower = enginePower;
    }

    public MotorCycle() {

    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }
}
