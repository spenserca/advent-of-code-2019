package com.spenserca.adventofcode2019.services;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DayOneService {
    public int calculateFuelRequirement(List<String> masses) {
        return masses
                .stream()
                .mapToInt(Integer::valueOf)
                .map((i) -> calculateFuelRequirement(i))
                .sum();
    }

    public int calculateFuelRequirement(int mass) {
        return mass / 3 - 2;
    }
}
