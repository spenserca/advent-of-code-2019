package com.spenserca.adventofcode2019.services;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DayThreeServiceTest {
    private DayThreeService underTest = new DayThreeService();
    private InputResourceService inputResourceService = new InputResourceService();

    @Test
    public void getManhattanDistanceFromClosestIntersection_CalledWithActualInput_ReturnsExpectedResult() throws IOException {
        int expected = 399;
        List<String> actualInput = inputResourceService.getInputForDay(3);

        int actual = underTest.getManhattanDistanceFromClosestIntersection(actualInput);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getManhattanDistanceFromClosestIntersection_CalledWithInput_Returns6() {
        String wireOne = "R8,U5,L5,D3";
        String wireTwo = "U7,R6,D4,L4";
        int expected = 6;

        int actual = underTest.getManhattanDistanceFromClosestIntersection(Arrays.asList(wireOne, wireTwo));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getManhattanDistanceFromClosestIntersection_CalledWithInput_Returns159() {
        String wireOne = "R75,D30,R83,U83,L12,D49,R71,U7,L72";
        String wireTwo = "U62,R66,U55,R34,D71,R55,D58,R83";
        int expected = 159;

        int actual = underTest.getManhattanDistanceFromClosestIntersection(Arrays.asList(wireOne, wireTwo));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getManhattanDistanceFromClosestIntersection_CalledWithInput_Returns135() {
        String wireOne = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51";
        String wireTwo = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7";
        int expected = 135;

        int actual = underTest.getManhattanDistanceFromClosestIntersection(Arrays.asList(wireOne, wireTwo));

        assertThat(actual).isEqualTo(expected);
    }
}