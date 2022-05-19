package com.gracie.demo.controller;

import com.gracie.demo.entity.ParkingSpace;
import com.gracie.demo.entity.Vehicle;
import com.gracie.demo.repository.ParkingRepository;
import com.gracie.demo.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class ParkingController {

    @Autowired
    ParkingRepository repository;

    @Autowired
    ParkingService service;

    @GetMapping
    public List<ParkingSpace> getAvailableParkingSpaces() {

        List<ParkingSpace> spaces = repository.findAll();
        return spaces.stream().filter(s -> !s.isOccupied()).collect(Collectors.toList());
    }

    @PostMapping("/parking")
    public Vehicle parkingVechicle(@RequestBody Vehicle v) {

        return service.parkingVechicle(v);
    }

    @DeleteMapping("unparking/{parkingSpaceId}")
    public String unparkingVechicle(@PathVariable("parkingSpaceId") int parkingSpaceId) {
        return service.unparkingVechicle(parkingSpaceId);
    }
}
