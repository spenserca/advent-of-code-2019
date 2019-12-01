package com.spenserca.adventofcode2019;

import com.spenserca.adventofcode2019.models.AdventOfCodeResponse;
import com.spenserca.adventofcode2019.services.InputResourceService;
import com.spenserca.adventofcode2019.services.TwentyNineteenDayOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class AdventOfCodeController {
    private TwentyNineteenDayOneService twentyNineteenDayOneService;
    private InputResourceService inputResourceService;

    @Autowired
    public AdventOfCodeController(
            TwentyNineteenDayOneService twentyNineteenDayOneService,
            InputResourceService inputResourceService
    ) {
        this.twentyNineteenDayOneService = twentyNineteenDayOneService;
        this.inputResourceService = inputResourceService;
    }

    @GetMapping(path = "/year/{yearId}/day/{dayId}/part/{partId}")
    public ResponseEntity get(@PathVariable int yearId, @PathVariable int dayId, @PathVariable String partId) throws IOException {
        List<String> input = inputResourceService.getInputForDay(1);
        Object result = input
                .stream()
                .mapToInt(Integer::valueOf)
                .map((i) -> twentyNineteenDayOneService.partOne(i))
                .sum();

        return ResponseEntity.ok(new AdventOfCodeResponse(yearId, dayId, partId, result));
    }
}
