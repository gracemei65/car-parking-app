package com.gracie.demo.service;

import com.gracie.demo.entity.ParkingSpace;
import com.gracie.demo.entity.Vehicle;
import com.gracie.demo.exception.ParkingException;
import com.gracie.demo.repository.ParkingRepository;
import com.gracie.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ParkingService {

    @Autowired
    ParkingRepository parkingRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle parkingVechicle(Vehicle v) {

        int size = v.getVehicleSize().getSize();
        int size1 = v.getVehicleSize().ordinal();
        List<ParkingSpace> spaces = parkingRepository.findAll();
        ParkingSpace space = spaces.stream().filter(s -> !s.isOccupied() && (s.getSpaceSize().getSize() >= v.getVehicleSize().getSize()))
                .sorted(Comparator.comparing(ParkingSpace::getSpaceSize)).findFirst().orElseThrow(() -> new ParkingException("no more parking space for your vehicle"));

        v.setParkingSpace(space);
        vehicleRepository.save(v);

        space.setOccupied(true);
        parkingRepository.save(space);
        return v;
    }

    public String unparkingVechicle(int parkingSpaceId) {

        ParkingSpace space = parkingRepository.findById(parkingSpaceId).orElseThrow(() -> new ParkingException("space is not found "));
        space.setOccupied(false);
        parkingRepository.save(space);

        Vehicle vehicle = vehicleRepository.findByParkingSpaceId(parkingSpaceId).orElseThrow(() -> new ParkingException("vechicle is not found "));

        vehicleRepository.deleteById(vehicle.getId());

        return "unparking the vehicle successfully ! ";

    }

}
