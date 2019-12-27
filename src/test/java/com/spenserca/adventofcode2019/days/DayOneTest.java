package com.spenserca.adventofcode2019.days;

import com.spenserca.adventofcode2019.services.DayOneService;
import com.spenserca.adventofcode2019.services.InputResourceService;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_METHOD;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@TestInstance(PER_METHOD)
public class DayOneTest {
    private DayOne underTest;
    private DayOneService mockDayOneService = mock(DayOneService.class);
    private InputResourceService mockInputResourceService = mock(InputResourceService.class);

    @BeforeEach
    public void setup() throws IOException {
        when(mockInputResourceService.getInputForDay(anyInt())).thenReturn(Collections.singletonList(RandomString.make(10)));
        when(mockDayOneService.calculateFuelRequirement(anyList())).thenReturn(new Random().nextInt());

        underTest = new DayOne(mockDayOneService, mockInputResourceService);
    }

    @Test
    @DisplayName("partOne calls inputResourceService.getInputForDay with 1")
    public void partOne_Called_CallsInputResourceServiceGetInputForDayWithExpectedValue() throws IOException {
        int expected = 1;

        underTest.partOne();

        verify(mockInputResourceService).getInputForDay(expected);
    }

    @Test
    @DisplayName("partOne calls dayOneService.calculateFuelRequirement with the output from input resource service")
    public void partOne_Called_CallsDayOneServiceWithExpectedValue() throws IOException {
        List<String> expected = Collections.singletonList(RandomString.make(10));
        when(mockInputResourceService.getInputForDay(anyInt())).thenReturn(expected);

        underTest.partOne();

        verify(mockDayOneService).calculateFuelRequirement(expected);
    }

    @Test
    @DisplayName("partOne returns the value from dayOneService.calculateFuelRequirement")
    public void partOne_Called_ReturnsExpectedOutput() throws IOException {
        int expected = new Random().nextInt();
        when(mockDayOneService.calculateFuelRequirement(anyList())).thenReturn(expected);

        int actual = (int) underTest.partOne();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("partTwo calls inputResourceService.getInputForDay with 1")
    public void partTwo_Called_CallsInputResourceServiceGetInputForDayWithExpectedValue() throws IOException {
        int expected = 1;

        underTest.partTwo();

        verify(mockInputResourceService).getInputForDay(expected);
    }

    @Test
    @DisplayName("partTwo calls dayOneService.recursivelyCalculateFuelRequirement with the output from input resource service")
    public void partTwo_Called_CallsDayOneServiceWithExpectedValue() throws IOException {
        List<String> expected = Collections.singletonList(RandomString.make(10));
        when(mockInputResourceService.getInputForDay(anyInt())).thenReturn(expected);

        underTest.partTwo();

        verify(mockDayOneService).recursivelyCalculateFuelRequirement(expected);
    }

    @Test
    @DisplayName("partTwo returns the value from dayOneService.recursivelyCalculateFuelRequirement")
    public void partTwo_Called_ReturnsExpectedOutput() throws IOException {
        int expected = new Random().nextInt();
        when(mockDayOneService.recursivelyCalculateFuelRequirement(anyList())).thenReturn(expected);

        int actual = (int) underTest.partTwo();

        assertThat(actual).isEqualTo(expected);
    }
}