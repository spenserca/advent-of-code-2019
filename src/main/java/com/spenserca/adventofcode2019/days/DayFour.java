package com.spenserca.adventofcode2019.days;

import com.spenserca.adventofcode2019.services.DayFourService;
import com.spenserca.adventofcode2019.services.InputResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class DayFour implements Day {
    private static final int DAY_FOUR = 4;
    private final DayFourService dayFourService;
    private final InputResourceService inputResourceService;

    @Autowired
    public DayFour(
            DayFourService dayFourService,
            InputResourceService inputResourceService
    ) {
        this.dayFourService = dayFourService;
        this.inputResourceService = inputResourceService;
    }

    @Override
    public Object partOne() throws IOException {
        List<String> input = inputResourceService.getInputForDay(DAY_FOUR);

        return dayFourService.getCountOfValidPasswords(input.get(0));
    }

    @Override
    public Object partTwo() throws IOException {
        List<String> input = inputResourceService.getInputForDay(DAY_FOUR);

        return dayFourService.getCountOfValidPasswordsWithDouble(input.get(0));
    }
}
