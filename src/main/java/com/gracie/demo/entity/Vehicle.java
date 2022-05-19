package com.gracie.demo.entity;

import javax.persistence.*;


@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private Size vehicleSize;

    private long parkingSpaceId;

    public Vehicle() {
    }

    public Vehicle(Size vehicleSize, long parkingSpaceId) {
        this.vehicleSize = vehicleSize;
        this.parkingSpaceId = parkingSpaceId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Size getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(Size vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public long getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void setParkingSpaceId(long parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }
}
