package com.spenserca.adventofcode2019.days;

import com.spenserca.adventofcode2019.services.DayOneService;
import com.spenserca.adventofcode2019.services.InputResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class DayOne implements Day {
    private static final int DAY_ONE = 1;
    private DayOneService dayOneService;
    private InputResourceService inputResourceService;

    @Autowired
    public DayOne(
        DayOneService dayOneService,
        InputResourceService inputResourceService
    ) {
        this.dayOneService = dayOneService;
        this.inputResourceService = inputResourceService;
    }

    @Override
    public Object partOne() throws IOException {
        List<String> input = inputResourceService.getInputForDay(DAY_ONE);

        return dayOneService.calculateFuelRequirement(input);
    }

    @Override
    public Object partTwo() throws IOException {
        List<String> input = inputResourceService.getInputForDay(DAY_ONE);

        return dayOneService.recursivelyCalculateFuelRequirement(input);
    }
}
