package com.spenserca.adventofcode2019.services;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DayOneServiceTest {
    private DayOneService underTest = new DayOneService();

    @Test
    public void calculateFuelRequirement_CalledWithMassOf12_Returns2() {
        int expected = 2;

        int actual = underTest.calculateFuelRequirement(12);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateFuelRequirement_CalledWithMassOf14_Returns2() {
        int expected = 2;

        int actual = underTest.calculateFuelRequirement(14);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateFuelRequirement_CalledWithMassOf17_Returns3() {
        int expected = 3;

        int actual = underTest.calculateFuelRequirement(17);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateFuelRequirement_CalledWithMassOf1969_Returns654() {
        int expected = 654;

        int actual = underTest.calculateFuelRequirement(1969);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateFuelRequirement_CalledWithMassOf100756_Returns33583() {
        int expected = 33583;

        int actual = underTest.calculateFuelRequirement(100756);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateFuelRequirement_CalledWithListOfStringMasses_ReturnsExpectedResult() {
        List<String> masses = Collections.singletonList("100756");
        int expected = 33583;

        int actual = underTest.calculateFuelRequirement(masses);

        assertThat(actual).isEqualTo(expected);
    }
}