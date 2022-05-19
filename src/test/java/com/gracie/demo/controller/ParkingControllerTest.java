package com.gracie.demo.controller;

import com.gracie.demo.entity.ParkingSpace;
import com.gracie.demo.entity.Size;
import com.gracie.demo.entity.Vehicle;
import com.gracie.demo.exception.ParkingException;
import com.gracie.demo.repository.ParkingRepository;
import com.gracie.demo.service.ParkingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ParkingControllerTest {

    @Mock
    ParkingRepository repository;

    @Mock
    ParkingService service;

    @InjectMocks
    ParkingController controller;

    @Test
    void parkingVechicleWithAvailableTheSameSize() {

        List<ParkingSpace> spaces = Arrays.asList(
                new ParkingSpace(Size.SMALL, false, -1),
                new ParkingSpace(Size.MEDIUM, false, -1),
                new ParkingSpace(Size.LARGE, false, -1)
        );

        Vehicle v = new Vehicle(Size.SMALL, -1);
        Mockito.when(service.parkingVechicle(v)).thenReturn(v);

        Vehicle result = controller.parkingVechicle(v);
        assertEquals(v.getId(), result.getId());
    }

    @Test
    void parkingVechicleWithAvailableBiggerSize() {

        List<ParkingSpace> spaces = Arrays.asList(
                new ParkingSpace(Size.SMALL, true, -1),
                new ParkingSpace(Size.MEDIUM, false, -1),
                new ParkingSpace(Size.LARGE, false, -1)
        );

        Vehicle v = new Vehicle(Size.SMALL, -1);
        Mockito.when(service.parkingVechicle(v)).thenReturn(v);

        Vehicle result = controller.parkingVechicle(v);
        assertEquals(v.getId(), result.getId());
    }

    @Test
    void parkingVechicleNotAvailable() {

        List<ParkingSpace> spaces = Arrays.asList(
                new ParkingSpace(Size.SMALL, false, -1),
                new ParkingSpace(Size.MEDIUM, false, -1),
                new ParkingSpace(Size.LARGE, true, -1)
        );

        Vehicle v = new Vehicle(Size.LARGE, -1);
        Mockito.when(service.parkingVechicle(v)).thenThrow(new ParkingException("o more parking space for your vehicle"));

        Assertions.assertThrows(ParkingException.class, () -> controller.parkingVechicle(v));
    }


    @Test
    void unparkingVechicle() {
    }
}