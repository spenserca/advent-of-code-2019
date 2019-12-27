package com.spenserca.adventofcode2019.days;

import com.spenserca.adventofcode2019.services.DayFourService;
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
public class DayFourTest {
    private DayFour underTest;
    private DayFourService mockDayFourService = mock(DayFourService.class);
    private InputResourceService mockInputResourceService = mock(InputResourceService.class);

    @BeforeEach
    public void setup() throws IOException {
        when(mockInputResourceService.getInputForDay(anyInt())).thenReturn(Collections.singletonList(RandomString.make(10)));
        when(mockDayFourService.getCountOfValidPasswords(anyString())).thenReturn(new Random().nextInt());
        when(mockDayFourService.getCountOfValidPasswordsWithDouble(anyString())).thenReturn(new Random().nextInt());

        underTest = new DayFour(mockDayFourService, mockInputResourceService);
    }

    @Test
    @DisplayName("partOne calls inputResourceService.getInputForDay with 4")
    public void partOne_Called_CallsInputResourceServiceGetInputForDay() throws IOException {
        int expected = 4;

        underTest.partOne();

        verify(mockInputResourceService).getInputForDay(expected);
    }

    @Test
    @DisplayName("partOne calls dayFourService.getCountOfValidPasswords with the output from input resource service")
    public void partOne_Called_CallsDayFourServiceWithExpectedValue() throws IOException {
        String expected = RandomString.make(10);
        when(mockInputResourceService.getInputForDay(anyInt())).thenReturn(Collections.singletonList(expected));

        underTest.partOne();

        verify(mockDayFourService).getCountOfValidPasswords(expected);
    }

    @Test
    @DisplayName("partOne returns the value from dayFourService.getCountOfValidPasswords")
    public void partOne_Called_ReturnsExpectedOutput() throws IOException {
        int expected = new Random().nextInt();
        when(mockDayFourService.getCountOfValidPasswords(anyString())).thenReturn(expected);

        int actual = (int) underTest.partOne();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("partTwo calls inputResourceService.getInputForDay with 4")
    public void partTwo_Called_CallsInputResourceServiceGetInputForDayWithExpectedValue() throws IOException {
        int expected = 4;

        underTest.partTwo();

        verify(mockInputResourceService).getInputForDay(expected);
    }

    @Test
    @DisplayName("partTwo calls dayFourService.getCountOfValidPasswordsWithDouble with the output from input resource service")
    public void partTwo_Called_CallsDayFourServiceWithExpectedValue() throws IOException {
        String expected = RandomString.make(10);
        when(mockInputResourceService.getInputForDay(anyInt())).thenReturn(Collections.singletonList(expected));

        underTest.partTwo();

        verify(mockDayFourService).getCountOfValidPasswordsWithDouble(expected);
    }

    @Test
    @DisplayName("partTwo returns the value from dayFourService.getCountOfValidPasswordsWithDouble")
    public void partTwo_Called_ReturnsExpectedOutput() throws IOException {
        int expected = new Random().nextInt();
        when(mockDayFourService.getCountOfValidPasswordsWithDouble(anyString())).thenReturn(expected);

        int actual = (int) underTest.partTwo();

        assertThat(actual).isEqualTo(expected);
    }
}