package com.spenserca.adventofcode2019.services;

import org.springframework.stereotype.Component;

@Component
public class ValidationService {
    public boolean hasMatchingAdjacentValues(String toValidate) {
        String[] characters = toValidate.split("");

        for (int i = 0; i < characters.length - 1; i++) {
            String current = characters[i];
            String next = characters[i + 1];

            if (current.equals(next)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasIncreasingValuesOnly(String toValidate) {
        String[] characters = toValidate.split("");

        for (int i = 0; i < characters.length - 1; i++) {
            Integer current = Integer.parseInt(characters[i]);
            Integer next = Integer.parseInt(characters[i + 1]);

            if (current > next) {
                return false;
            }
        }

        return true;
    }
}
