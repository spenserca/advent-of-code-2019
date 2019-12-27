package com.spenserca.adventofcode2019.days;

import com.spenserca.adventofcode2019.services.DayThreeService;
import com.spenserca.adventofcode2019.services.InputResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class DayThree implements Day {
    private static final int DAY_THREE = 3;
    private final DayThreeService dayThreeService;
    private final InputResourceService inputResourceService;

    @Autowired
    public DayThree(
            DayThreeService dayThreeService,
            InputResourceService inputResourceService
    ) {
        this.dayThreeService = dayThreeService;
        this.inputResourceService = inputResourceService;
    }

    @Override
    public Object partOne() throws IOException {
        List<String> input = inputResourceService.getInputForDay(DAY_THREE);

        return dayThreeService.getManhattanDistanceFromClosestIntersection(input);
    }

    @Override
    public Object partTwo() throws IOException {
        List<String> input = inputResourceService.getInputForDay(DAY_THREE);

        return dayThreeService.getMinimumStepsToIntersection(input);
    }
}
