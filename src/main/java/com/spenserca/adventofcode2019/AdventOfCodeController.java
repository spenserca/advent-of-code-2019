package com.spenserca.adventofcode2019;

import com.spenserca.adventofcode2019.models.AdventOfCodeResponse;
import com.spenserca.adventofcode2019.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdventOfCodeController {
    private DayOneService dayOneService;
    private DayTwoService dayTwoService;
    private DayThreeService dayThreeService;
    private DayFourService dayFourService;
    private InputResourceService inputResourceService;

    @Autowired
    public AdventOfCodeController(
            DayOneService dayOneService,
            DayTwoService dayTwoService,
            DayThreeService dayThreeService,
            DayFourService dayFourService,
            InputResourceService inputResourceService
    ) {
        this.dayOneService = dayOneService;
        this.dayTwoService = dayTwoService;
        this.dayThreeService = dayThreeService;
        this.dayFourService = dayFourService;
        this.inputResourceService = inputResourceService;
    }

    @GetMapping(path = "/year/{year}/day/{day}/part/{part}")
    public ResponseEntity<AdventOfCodeResponse> get(
            @PathVariable int year,
            @PathVariable int day,
            @PathVariable int part
    ) {
        Object result = null;
        List<String> input;

        try {
            input = inputResourceService.getInputForDay(day);
        } catch (Exception e) {
            throw new RuntimeException("Error getting input for /year" + year + "/day/" + day + "/part/" + part);
        }

        if (day == 1) {
            if (part == 1) {
                result = dayOneService.calculateFuelRequirement(input);
            } else if (part == 2) {
                result = dayOneService.recursivelyCalculateFuelRequirement(input);
            }
        }
        if (day == 2) {
            if (part == 1) {
                int noun = 12;
                int verb = 2;
                result = dayTwoService.runIntCodeProgram(input.get(0), noun, verb);
            } else if (part == 2) {
                int desiredOutput = 19690720;
                result = dayTwoService.getNounVerbPairForDesiredOutput(input.get(0), desiredOutput);
            }
        }
        if (day == 3) {
            if (part == 1) {
                result = dayThreeService.getManhattanDistanceFromClosestIntersection(input);
            } else if (part == 2) {
                result = dayThreeService.getMinimumStepsToIntersection(input);
            }
        }
        if (day == 4) {
            if (part == 1) {
                result = dayFourService.getCountOfValidPasswords(input.get(0));
            } else if (part == 2) {
                result = dayFourService.getCountOfValidPasswordsWithDouble(input.get(0));
            }
        }

        return ResponseEntity.ok(new AdventOfCodeResponse(year, day, part, result));
    }
}
