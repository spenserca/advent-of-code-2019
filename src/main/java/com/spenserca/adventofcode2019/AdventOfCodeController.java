package com.spenserca.adventofcode2019;

import com.spenserca.adventofcode2019.models.AdventOfCodeResponse;
import com.spenserca.adventofcode2019.services.DayOneService;
import com.spenserca.adventofcode2019.services.InputResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdventOfCodeController {
    private DayOneService dayOneService;
    private InputResourceService inputResourceService;

    @Autowired
    public AdventOfCodeController(
            DayOneService dayOneService,
            InputResourceService inputResourceService
    ) {
        this.dayOneService = dayOneService;
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
            }
        }

        return ResponseEntity.ok(new AdventOfCodeResponse(year, day, part, result));
    }
}
