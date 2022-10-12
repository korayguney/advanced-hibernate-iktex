package com.iktex.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Car extends Vehicle {
    private String color;

    public Car(String v_model, int v_year, String v_plate, String color) {
        super(v_model, v_year, v_plate);
        this.color = color;
    }

    public Car(String color) {
        this.color = color;
    }

    public Car(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
