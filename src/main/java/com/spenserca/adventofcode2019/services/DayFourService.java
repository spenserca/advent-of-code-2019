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
        int lowerBound = Integer.parseInt(range.split("-")[0]);
        int upperBound = Integer.parseInt(range.split("-")[1]);
        int validPasswordsCount = 0;

        for (int i = lowerBound; i <= upperBound; i++) {
            if (isValidPassword(i)) {
                validPasswordsCount++;
            }
        }

        return validPasswordsCount;
    }

    private boolean isValidPassword(int i) {
        String intAsString = String.valueOf(i);
        return validationService.hasIncreasingValuesOnly(intAsString)
                && validationService.hasMatchingAdjacentValues(intAsString);
    }
}
