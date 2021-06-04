package com.gracie.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpace {
    @Id
    private Integer id;
    private  Size spaceSize;
    private Boolean isOccupied;
    private Integer vechicleId;

}
