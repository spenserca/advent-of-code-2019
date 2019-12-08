package com.spenserca.adventofcode2019.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@TestInstance(PER_CLASS)
public class DayFourServiceTest {
    private DayFourService underTest;
    private ValidationService mockValidationService = mock(ValidationService.class);

    @BeforeAll
    public void setup() {
        when(mockValidationService.hasIncreasingValuesOnly(anyString())).thenReturn(true);
        when(mockValidationService.hasMatchingAdjacentValues(anyString())).thenReturn(true);
        when(mockValidationService.isSixDigits(anyString())).thenReturn(true);

        underTest = new DayFourService(mockValidationService);
    }

    @Test
    public void getCountOfValidPasswords_Called_CallsValidationServiceHasIncreasingValuesOnlyWithTheExpectedParamsForEachValueInRange() {
        String range = "111110-111112";

        underTest.getCountOfValidPasswords(range);

        verify(mockValidationService).hasIncreasingValuesOnly("111110");
        verify(mockValidationService).hasIncreasingValuesOnly("111111");
        verify(mockValidationService).hasIncreasingValuesOnly("111112");
    }

    @Test
    public void getCountOfValidPasswords_Called_CallsValidationServiceHasMatchingAdjacentValuesWithTheExpectedParamsForEachValueInRange() {
        String range = "111110-111112";

        underTest.getCountOfValidPasswords(range);

        verify(mockValidationService).hasMatchingAdjacentValues("111110");
        verify(mockValidationService).hasMatchingAdjacentValues("111111");
        verify(mockValidationService).hasMatchingAdjacentValues("111112");
    }

    @Test
    public void getCountOfValidPasswords_Called_CallsValidationServiceIsSixDigitsWithTheExpectedParamsForEachValueInRange() {
        String range = "111110-111112";

        underTest.getCountOfValidPasswords(range);

        verify(mockValidationService).isSixDigits("111110");
        verify(mockValidationService).isSixDigits("111111");
        verify(mockValidationService).isSixDigits("111112");
    }
}