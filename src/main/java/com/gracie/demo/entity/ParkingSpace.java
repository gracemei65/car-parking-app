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
    private long id;

    @Enumerated(EnumType.STRING)
    private Size spaceSize;

    private boolean isOccupied;
    
    private int vechicleId;

    public ParkingSpace() {
    }

    public ParkingSpace(Size spaceSize, boolean isOccupied, int vechicleId) {
        this.spaceSize = spaceSize;
        this.isOccupied = isOccupied;
        this.vechicleId = vechicleId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getVechicleId() {
        return vechicleId;
    }

    public void setVechicleId(int vechicleId) {
        this.vechicleId = vechicleId;
    }
}
