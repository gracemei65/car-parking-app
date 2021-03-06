package com.gracie.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "parking_space")
public class ParkingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    private Size spaceSize;

    private boolean isOccupied;


    public ParkingSpace() {
    }

    public ParkingSpace(Size spaceSize, boolean isOccupied) {
        this.spaceSize = spaceSize;
        this.isOccupied = isOccupied;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Size getSpaceSize() {
        return spaceSize;
    }

    public void setSpaceSize(Size spaceSize) {
        this.spaceSize = spaceSize;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
