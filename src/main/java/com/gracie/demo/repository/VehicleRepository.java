package com.gracie.demo.repository;

import com.gracie.demo.entity.ParkingSpace;
import com.gracie.demo.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    Optional<Vehicle> findByParkingSpaceId(int parkingSpaceId);
}
