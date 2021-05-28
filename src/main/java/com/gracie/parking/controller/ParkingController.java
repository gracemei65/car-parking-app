package com.gracie.parking.controller;

import com.gracie.parking.entity.ParkingSpace;
import com.gracie.parking.entity.Vehicle;
import com.gracie.parking.repository.ParkingRepository;
import com.gracie.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    ParkingRepository repository;

    @Autowired
    ParkingService service;

    @GetMapping
    public List<ParkingSpace> getAvailableParkingSpaces( ){

        List<ParkingSpace> spaces=repository.findAll();
        return spaces.stream().filter(s->!s.getIsOccupied()).collect(Collectors.toList());
    }

    @PostMapping
    public Vehicle parkingVechicle(@RequestBody Vehicle v){
           return service.parkingVechicle(v);
    }

    @DeleteMapping
    public void unparkingVechicle(Vehicle v){
         service.unparkingVechicle(v);
    }
}
