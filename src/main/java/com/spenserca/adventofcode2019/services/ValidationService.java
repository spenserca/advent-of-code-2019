package com.spenserca.adventofcode2019.services;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ValidationService {
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

    public boolean hasDouble(String toValidate) {
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
                    adjacentValueCounts.put(current, 2);
                }
            }
        }

        return adjacentValueCounts.containsValue(2);
    }
}
