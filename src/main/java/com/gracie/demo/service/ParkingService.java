package com.gracie.demo.service;

import com.gracie.demo.entity.ParkingSpace;
import com.gracie.demo.entity.Vehicle;
import com.gracie.demo.exception.ParkingException;
import com.gracie.demo.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ParkingService {

    @Autowired
    ParkingRepository repository;

    public Vehicle parkingVechicle(Vehicle v) {

        int size=v.getVehicleSize().getSize();
        int size1 =v.getVehicleSize().ordinal();
        List<ParkingSpace> spaces = repository.findAll();
        ParkingSpace space = spaces.stream().filter(s -> !s.isOccupied() && (s.getSpaceSize().getSize()>= v.getVehicleSize().getSize()))
                .sorted(Comparator.comparing(ParkingSpace::getSpaceSize)).findFirst().orElseThrow(() -> new ParkingException("no more parking space for your vehicle"));

        space.setOccupied(true);
        repository.save(space);
        v.setParkingSpaceId(space.getId());
        return v;
    }

    public void unparkingVechicle(Vehicle v) {

        List<ParkingSpace> spaces = repository.findAll();
        ParkingSpace space = spaces.stream().filter(s -> s.getVechicleId()==(v.getId())).findFirst().orElseThrow(() -> new ParkingException("your car not parking yet"));
        space.setOccupied(false);
        space.setVechicleId(-1);
        repository.save(space);

    }

}
