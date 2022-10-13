package com.iktex.hb04.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MotorCycle extends Vehicle {
    private double enginePower;

    public MotorCycle(String v_model, int v_year, String v_plate, double enginePower) {
        super(v_model, v_year, v_plate);
        this.enginePower = enginePower;
    }

}
