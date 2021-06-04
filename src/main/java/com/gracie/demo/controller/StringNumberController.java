package com.gracie.demo.controller;


import com.gracie.demo.service.StringNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringNumberController {

    @Autowired
    StringNumberService service;

    @GetMapping("/{strNum}")
    public boolean isNumberic(@PathVariable String strNum)
    {
        return service.isNumberic(strNum);
    }
}
