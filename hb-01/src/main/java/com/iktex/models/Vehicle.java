package com.iktex.models;

public class Vehicle {
    private String v_model;
    private int v_year;
    private String v_plate;

    public Vehicle(String v_model, int v_year, String v_plate) {
        this.v_model = v_model;
        this.v_year = v_year;
        this.v_plate = v_plate;
    }

    public Vehicle() {
    }

    public String getV_model() {
        return v_model;
    }

    public void setV_model(String v_model) {
        this.v_model = v_model;
    }

    public int getV_year() {
        return v_year;
    }

    public void setV_year(int v_year) {
        this.v_year = v_year;
    }

    public String getV_plate() {
        return v_plate;
    }

    public void setV_plate(String v_plate) {
        this.v_plate = v_plate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        return v_plate != null ? v_plate.equals(vehicle.v_plate) : vehicle.v_plate == null;
    }

    @Override
    public int hashCode() {
        return v_plate != null ? v_plate.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "v_model='" + v_model + '\'' +
                ", v_year=" + v_year +
                ", v_plate='" + v_plate + '\'' +
                '}';
    }
}
