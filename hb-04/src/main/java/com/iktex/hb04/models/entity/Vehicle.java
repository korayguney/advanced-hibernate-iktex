package com.iktex.hb04.models.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
public class Vehicle extends AbstractBaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String v_model;
    private int v_year;
    private String v_plate;

    @ManyToMany
    @JsonManagedReference
    private List<Accident> accident = new ArrayList<>();

    @ManyToOne
    @JsonManagedReference
    private Customer customer;

    public Vehicle(String v_model, int v_year, String v_plate) {
        this.v_model = v_model;
        this.v_year = v_year;
        this.v_plate = v_plate;
    }
}
