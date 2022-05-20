package com.gracie.demo.entity;

import javax.persistence.*;


@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    private Size vehicleSize;

    @OneToOne
    @JoinColumn(name = "parkingspace_id", referencedColumnName = "id")
    private ParkingSpace parkingSpace;

    public Vehicle() {
    }

    public Vehicle(Size vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
