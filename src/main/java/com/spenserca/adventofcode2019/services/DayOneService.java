package com.spenserca.adventofcode2019.services;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DayOneService {
    public int recursivelyCalculateFuelRequirement(List<String> masses) {
        return masses
                .stream()
                .mapToInt(Integer::valueOf)
                .map(this::recursivelyCalculateFuelRequirement)
                .sum();
    }

    public int calculateFuelRequirement(List<String> masses) {
        return masses
                .stream()
                .mapToInt(Integer::valueOf)
                .map(this::calculateFuelRequirement)
                .sum();
    }

    private int recursivelyCalculateFuelRequirement(int mass) {
        int totalFuelRequirement = 0;

        while (calculateFuelRequirement(mass) > 0) {
            totalFuelRequirement += calculateFuelRequirement(mass);
            mass = calculateFuelRequirement(mass);
        }

        return totalFuelRequirement;
    }

    private int calculateFuelRequirement(int mass) {
        return mass / 3 - 2;
    }
}
