package com.spenserca.adventofcode2019.services;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DayOneServiceTest {
    private DayOneService underTest = new DayOneService();
    private InputResourceService inputResourceService = new InputResourceService();

    @Test
    public void calculateFuelRequirement_CalledWithActualInput_ReturnsExpectedResult() throws IOException {
        int expected = 3327415;
        List<String> actualInput = inputResourceService.getInputForDay(1);

        int actual = underTest.calculateFuelRequirement(actualInput);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void recursivelyCalculateFuelRequirement_CalledWithActualInput_ReturnsExpectedResult() throws IOException {
        int expected = 4988257;
        List<String> actualInput = inputResourceService.getInputForDay(1);

        int actual = underTest.recursivelyCalculateFuelRequirement(actualInput);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateFuelRequirement_CalledWithMassOf12_Returns2() {
        int expected = 2;

        int actual = underTest.calculateFuelRequirement(Collections.singletonList("12"));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateFuelRequirement_CalledWithMassOf14_Returns2() {
        int expected = 2;

        int actual = underTest.calculateFuelRequirement(Collections.singletonList("14"));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateFuelRequirement_CalledWithMassOf17_Returns3() {
        int expected = 3;

        int actual = underTest.calculateFuelRequirement(Collections.singletonList("17"));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateFuelRequirement_CalledWithMassOf1969_Returns654() {
        int expected = 654;

        int actual = underTest.calculateFuelRequirement(Collections.singletonList("1969"));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateFuelRequirement_CalledWithMassOf100756_Returns33583() {
        int expected = 33583;

        int actual = underTest.calculateFuelRequirement(Collections.singletonList("100756"));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void recursivelyCalculateFuelRequirement_CalledWith14_Returns2() {
        int expected = 2;

        int actual = underTest.recursivelyCalculateFuelRequirement(Collections.singletonList("14"));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void recursivelyCalculateFuelRequirement_CalledWith1969_Returns966() {
        int expected = 966;

        int actual = underTest.recursivelyCalculateFuelRequirement(Collections.singletonList("1969"));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void recursivelyCalculateFuelRequirement_CalledWith100756_Returns50346() {
        int expected = 50346;

        int actual = underTest.recursivelyCalculateFuelRequirement(Collections.singletonList("100756"));

        assertThat(actual).isEqualTo(expected);
    }
}