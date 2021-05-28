package com.gracie.parking.repository;

import com.gracie.parking.entity.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<ParkingSpace, Integer> {
}
