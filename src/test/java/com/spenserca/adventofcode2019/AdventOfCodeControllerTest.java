package com.spenserca.adventofcode2019;

import com.spenserca.adventofcode2019.services.DayOneService;
import com.spenserca.adventofcode2019.services.InputResourceService;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AdventOfCodeControllerTest {
    private AdventOfCodeController underTest;
    private DayOneService mockDayOneService = mock(DayOneService.class);
    private InputResourceService mockInputResourceService = mock(InputResourceService.class);

    @BeforeAll
    public void setup() throws IOException {
        when(mockDayOneService.calculateFuelRequirement(anyList()))
                .thenReturn(new Random().nextInt());
        when(mockInputResourceService.getInputForDay(anyInt()))
                .thenReturn(Collections.singletonList(RandomString.make(8)));

        underTest = new AdventOfCodeController(
                mockDayOneService,
                mockInputResourceService
        );
    }

    @Test
    public void get_Called_CallsInputResourceServiceGetInputForDayWithThePassedInDay() throws IOException {
        int expected = new Random().nextInt();

        underTest.get(new Random().nextInt(), expected, new Random().nextInt());

        verify(mockInputResourceService).getInputForDay(expected);
    }

    @Test
    public void get_CalledWithDay1Part1_CallsDayOneServiceCalculateFuelRequirementWithTheExpectedParams() throws IOException {
        List<String> expected = Collections.singletonList(RandomString.make(8));
        when(mockInputResourceService.getInputForDay(anyInt())).thenReturn(expected);

        underTest.get(new Random().nextInt(), 1, 1);

        verify(mockDayOneService).calculateFuelRequirement(expected);
    }
}