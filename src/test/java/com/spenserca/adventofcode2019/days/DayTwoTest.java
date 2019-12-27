package com.spenserca.adventofcode2019.days;

import com.spenserca.adventofcode2019.services.DayTwoService;
import com.spenserca.adventofcode2019.services.InputResourceService;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.util.Collections;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_METHOD;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@TestInstance(PER_METHOD)
public class DayTwoTest {
    private DayTwo underTest;
    private DayTwoService mockDayTwoService = mock(DayTwoService.class);
    private InputResourceService mockInputResourceService = mock(InputResourceService.class);

    @BeforeEach
    public void setup() throws IOException {
        when(mockInputResourceService.getInputForDay(anyInt())).thenReturn(Collections.singletonList(RandomString.make(10)));
        when(mockDayTwoService.runIntCodeProgram(anyString(), anyInt(), anyInt())).thenReturn(new Random().nextInt());
        when(mockDayTwoService.getNounVerbPairForDesiredOutput(anyString(), anyInt())).thenReturn(new int[]{new Random().nextInt()});

        underTest = new DayTwo(mockDayTwoService, mockInputResourceService);
    }

    @Test
    @DisplayName("partOne calls inputResourceService.getInputForDay with 2")
    public void partOne_Called_CallsInputResourceServiceGetInputForDay() throws IOException {
        int expected = 2;

        underTest.partOne();

        verify(mockInputResourceService).getInputForDay(expected);
    }

    @Test
    @DisplayName("partOne calls dayTwoService.runIntCodeProgram with the output from input resource service")
    public void partOne_Called_CallsDayTwoServiceWithExpectedValue() throws IOException {
        String expectedInitialMemoryState = RandomString.make(10);
        int expectedNoun = 12;
        int expectedVerb = 2;
        when(mockInputResourceService.getInputForDay(anyInt())).thenReturn(Collections.singletonList(expectedInitialMemoryState));

        underTest.partOne();

        verify(mockDayTwoService).runIntCodeProgram(expectedInitialMemoryState, expectedNoun, expectedVerb);
    }

    @Test
    @DisplayName("partOne returns the value from dayTwoService.runIntCodeProgram")
    public void partOne_Called_ReturnsExpectedOutput() throws IOException {
        int expected = new Random().nextInt();
        when(mockDayTwoService.runIntCodeProgram(anyString(), anyInt(), anyInt())).thenReturn(expected);

        int actual = (int) underTest.partOne();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("partTwo calls inputResourceService.getInputForDay with 2")
    public void partTwo_Called_CallsInputResourceServiceGetInputForDayWithExpectedValue() throws IOException {
        int expected = 2;

        underTest.partTwo();

        verify(mockInputResourceService).getInputForDay(expected);
    }

    @Test
    @DisplayName("partTwo calls dayTwoService.getNounVerbPairForDesiredOutput with the output from input resource service")
    public void partTwo_Called_CallsDayTwoServiceWithExpectedValue() throws IOException {
        int expectedDesiredOutput = 19690720;
        String expectedInitialMemoryState = RandomString.make(10);
        when(mockInputResourceService.getInputForDay(anyInt())).thenReturn(Collections.singletonList(expectedInitialMemoryState));

        underTest.partTwo();

        verify(mockDayTwoService).getNounVerbPairForDesiredOutput(expectedInitialMemoryState, expectedDesiredOutput);
    }

    @Test
    @DisplayName("partTwo returns the value from dayTwoService.getNounVerbPairForDesiredOutput")
    public void partTwo_Called_ReturnsExpectedOutput() throws IOException {
        int[] expected = new int[]{new Random().nextInt()};
        when(mockDayTwoService.getNounVerbPairForDesiredOutput(anyString(), anyInt())).thenReturn(expected);

        int[] actual = (int[]) underTest.partTwo();

        assertThat(actual).isEqualTo(expected);
    }
}