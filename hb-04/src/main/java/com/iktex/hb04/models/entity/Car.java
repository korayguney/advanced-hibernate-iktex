package com.iktex.hb04.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Car extends Vehicle {
    private String color;

    public Car(String v_model, int v_year, String v_plate, String color) {
        super(v_model, v_year, v_plate);
        this.color = color;
    }
}
