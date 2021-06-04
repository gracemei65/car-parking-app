package com.gracie.demo.service;

import com.gracie.demo.entity.ParkingSpace;
import com.gracie.demo.entity.Size;
import com.gracie.demo.repository.ParkingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class ParkingSpaceInitializer implements CommandLineRunner {

    @Autowired
    ParkingRepository repository;

    @Override
    public void run(String... args) throws Exception {

        log.info(" create a few parking spaces");

        List<ParkingSpace> spaces = Arrays.asList(
                new ParkingSpace(1, Size.SMALL, false, -1),
                new ParkingSpace(2, Size.LARGE, false, -1) ,
                new ParkingSpace(3, Size.MEDIUM, false, -1),
                new ParkingSpace(4, Size.LARGE, false, -1),
                new ParkingSpace(5, Size.MEDIUM, false, -1)
        );

        repository.saveAll(spaces);
    }
}
