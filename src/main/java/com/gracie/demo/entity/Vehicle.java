package com.gracie.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    private Integer id;
    private Size vehicleSize;
    private Integer parkingSpaceId;

}
