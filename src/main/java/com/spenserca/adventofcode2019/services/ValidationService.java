package com.spenserca.adventofcode2019.services;

import org.springframework.stereotype.Component;

@Component
public class ValidationService {

    public boolean isSixDigits(String toValidate) {
        return toValidate.length() == 6;
    }

    public boolean isWithinRange(int lowerBound, int upperBound, int toValidate) {
        return toValidate >= lowerBound && toValidate <= upperBound;
    }

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
        boolean hasIncreasingValuesOnly = false;

        for (int i = 0; i < characters.length - 1; i++) {
            Integer current = Integer.parseInt(characters[i]);
            Integer next = Integer.parseInt(characters[i + 1]);

            hasIncreasingValuesOnly = current <= next;
        }

        return hasIncreasingValuesOnly;
    }
}
