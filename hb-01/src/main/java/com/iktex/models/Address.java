package com.iktex.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Address {
    @EmbeddedId
    private Coordinate id;
    private String details;

    public Address(Coordinate id, String details) {
        this.id = id;
        this.details = details;
    }

    public Address() {
    }

    public Coordinate getId() {
        return id;
    }

    public void setId(Coordinate id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
