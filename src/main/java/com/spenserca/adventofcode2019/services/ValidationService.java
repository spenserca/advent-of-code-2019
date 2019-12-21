package com.spenserca.adventofcode2019.services;

import org.springframework.stereotype.Component;

import java.util.HashMap;

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
        HashMap<String, Integer> adjacentValueCounts = new HashMap<>();

        for (int i = 0; i < characters.length - 1; i++) {
            String current = characters[i];
            String next = characters[i + 1];

            if (current.equals(next)) {
                if (adjacentValueCounts.containsKey(current)) {
                    int currentCount = adjacentValueCounts.get(current);
                    adjacentValueCounts.put(current, currentCount + 1);
                } else {
                    adjacentValueCounts.put(current, 1);
                }
            }
        }

        return !adjacentValueCounts.isEmpty();
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
