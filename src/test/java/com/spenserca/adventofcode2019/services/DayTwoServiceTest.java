package com.spenserca.adventofcode2019.services;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DayTwoServiceTest {
    private DayTwoService underTest = new DayTwoService();
    private InputResourceService inputResourceService = new InputResourceService();

    @Test
    public void runIntCodeProgram_CalledWithActualInput_ReturnsExpectedResult() throws IOException {
        int expected = 3306701;
        List<String> actualInput = inputResourceService.getInputForDay(2);

        int actual = underTest.runIntCodeProgram(actualInput.get(0), 12, 2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void runIntCodeProgram_Called_Returns2() {
        String input = "1,0,0,0,99";
        int expected = 2;

        int actual = underTest.runIntCodeProgram(input, 0, 0);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void runIntCodeProgram_Called_Returns6() {
        String input = "2,3,0,3,99";
        int expected = 2;

        int actual = underTest.runIntCodeProgram(input, 3, 0);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void runIntCodeProgram_Called_Returns9801() {
        String input = "2,4,4,5,99,0";
        int expected = 2;

        int actual = underTest.runIntCodeProgram(input, 4, 4);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void runIntCodeProgram_Called_Returns30() {
        String input = "1,1,1,4,99,5,6,0,99";
        int expected = 30;

        int actual = underTest.runIntCodeProgram(input, 1, 1);

        assertThat(actual).isEqualTo(expected);
    }
}