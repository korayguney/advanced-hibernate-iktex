package com.iktex.models;

import javax.persistence.*;

@Entity
@SecondaryTable(name = "address_coordinates")
@SecondaryTable(name = "address_coordinates2")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(table = "address_coordinates")
    private Long xId;
    @Column(table = "address_coordinates2")
    private Long yId;

    private String details;

    public Address(Long xId, Long yId, String details) {
        this.xId = xId;
        this.yId = yId;
        this.details = details;
    }

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Long getxId() {
        return xId;
    }

    public void setxId(Long xId) {
        this.xId = xId;
    }

    public Long getyId() {
        return yId;
    }

    public void setyId(Long yId) {
        this.yId = yId;
    }
}
