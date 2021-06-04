package com.gracie.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.regex.Pattern;

@Service
public class StringNumberService {

    public boolean isNumberic(@PathVariable String strNum)
    {
        Pattern pattern =Pattern.compile("-?\\d+(\\.\\d+)?");
        return pattern.matcher(strNum).matches();

    }
}
