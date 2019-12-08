package com.spenserca.adventofcode2019.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DayFourService {
    private ValidationService validationService;

    @Autowired
    public DayFourService(ValidationService validationService) {
        this.validationService = validationService;
    }

    public int getCountOfValidPasswords(String range) {
        return 0;
    }
}
