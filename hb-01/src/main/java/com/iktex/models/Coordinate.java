package com.iktex.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Coordinate implements Serializable {
    private int xCoord;
    private int yCoord;

    public Coordinate(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public Coordinate() {

    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
}
