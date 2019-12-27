package com.spenserca.adventofcode2019.days;

import com.spenserca.adventofcode2019.services.DayTwoService;
import com.spenserca.adventofcode2019.services.InputResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class DayTwo implements Day {
    private static final int DAY_TWO = 2;
    private static final int NOUN = 12;
    private static final int VERB = 2;
    private static final int PART_TWO_DESIRED_OUTPUT = 19690720;
    private final DayTwoService dayTwoService;
    private final InputResourceService inputResourceService;

    @Autowired
    public DayTwo(
            DayTwoService dayTwoService,
            InputResourceService inputResourceService
    ) {
        this.dayTwoService = dayTwoService;
        this.inputResourceService = inputResourceService;
    }

    @Override
    public Object partOne() throws IOException {
        List<String> input = inputResourceService.getInputForDay(DAY_TWO);

        return dayTwoService.runIntCodeProgram(input.get(0), NOUN, VERB);
    }

    @Override
    public Object partTwo() throws IOException {
        List<String> input = inputResourceService.getInputForDay(DAY_TWO);

        return dayTwoService.getNounVerbPairForDesiredOutput(input.get(0), PART_TWO_DESIRED_OUTPUT);
    }
}
