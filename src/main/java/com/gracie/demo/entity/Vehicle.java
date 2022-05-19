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

    @OneToOne(mappedBy = "vehicle")
    private ParkingSpace parkingSpace;

    public Vehicle() {
    }

    public Vehicle(Size vehicleSize) {
        this.vehicleSize = vehicleSize;
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

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }
}
