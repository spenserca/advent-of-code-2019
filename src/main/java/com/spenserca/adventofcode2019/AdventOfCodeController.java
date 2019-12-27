package com.spenserca.adventofcode2019;

import com.spenserca.adventofcode2019.days.DayFour;
import com.spenserca.adventofcode2019.days.DayOne;
import com.spenserca.adventofcode2019.days.DayThree;
import com.spenserca.adventofcode2019.days.DayTwo;
import com.spenserca.adventofcode2019.models.AdventOfCodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AdventOfCodeController {
    private DayOne dayOne;
    private DayTwo dayTwo;
    private DayThree dayThree;
    private DayFour dayFour;

    @Autowired
    public AdventOfCodeController(
            DayOne dayOne,
            DayTwo dayTwo,
            DayThree dayThree,
            DayFour dayFour
    ) {
        this.dayOne = dayOne;
        this.dayTwo = dayTwo;
        this.dayThree = dayThree;
        this.dayFour = dayFour;
    }

    @GetMapping(path = "/year/{year}/day/{day}/part/{part}")
    public ResponseEntity<AdventOfCodeResponse> get(
            @PathVariable int year,
            @PathVariable int day,
            @PathVariable int part
    ) throws IOException {
        Object result = null;

        if (day == 1) {
            if (part == 1) {
                result = dayOne.partOne();
            } else if (part == 2) {
                result = dayOne.partTwo();
            }
        }
        if (day == 2) {
            if (part == 1) {
                result = dayTwo.partOne();
            } else if (part == 2) {
                result = dayTwo.partTwo();
            }
        }
        if (day == 3) {
            if (part == 1) {
                result = dayThree.partOne();
            } else if (part == 2) {
                result = dayThree.partTwo();
            }
        }
        if (day == 4) {
            if (part == 1) {
                result = dayFour.partOne();
            } else if (part == 2) {
                result = dayFour.partTwo();
            }
        }

        return ResponseEntity.ok(new AdventOfCodeResponse(year, day, part, result));
    }
}
