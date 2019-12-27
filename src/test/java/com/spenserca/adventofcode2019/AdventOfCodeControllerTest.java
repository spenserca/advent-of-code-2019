package com.spenserca.adventofcode2019;

import com.spenserca.adventofcode2019.days.DayOne;
import com.spenserca.adventofcode2019.models.AdventOfCodeResponse;
import com.spenserca.adventofcode2019.services.DayFourService;
import com.spenserca.adventofcode2019.services.DayThreeService;
import com.spenserca.adventofcode2019.services.DayTwoService;
import com.spenserca.adventofcode2019.services.InputResourceService;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.*;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Collections;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_METHOD;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@TestInstance(PER_METHOD)
public class AdventOfCodeControllerTest {
    private AdventOfCodeController underTest;
    private DayOne mockDayOne = mock(DayOne.class);
    private DayTwoService mockDayTwoService = mock(DayTwoService.class);
    private DayThreeService mockDayThreeService = mock(DayThreeService.class);
    private DayFourService mockDayFourService = mock(DayFourService.class);
    private InputResourceService mockInputResourceService = mock(InputResourceService.class);

    @BeforeEach
    public void setup() throws IOException {
        when(mockDayOne.partOne()).thenReturn(new Random().nextInt());
        when(mockDayOne.partTwo()).thenReturn(new Random().nextInt());
        when(mockInputResourceService.getInputForDay(anyInt()))
            .thenReturn(Collections.singletonList(RandomString.make(8)));

        underTest = new AdventOfCodeController(
            mockDayOne,
            mockDayTwoService,
            mockDayThreeService,
            mockDayFourService,
            mockInputResourceService
        );
    }

    @Nested
    @DisplayName("Day One Part One Tests")
    class dayOnePartOneTests {
        @Test
        @DisplayName("calls dayOne.partOne")
        public void get_CalledWithDay1Part1_CallsExpected() throws IOException {
            underTest.get(new Random().nextInt(), 1, 1);

            verify(mockDayOne).partOne();
        }

        @Test
        @DisplayName("returns the expected value")
        public void get_Called_ReturnsExpectedValue() throws IOException {
            int expectedYear = new Random().nextInt();
            int expectedDay = 1;
            int expectedPart = 1;
            int expectedResult = new Random().nextInt();
            when(mockDayOne.partOne()).thenReturn(expectedResult);

            ResponseEntity<AdventOfCodeResponse> response = underTest.get(expectedYear, expectedDay, expectedPart);

            AdventOfCodeResponse actual = response.getBody();
            assertThat(actual.getYear()).isEqualTo(expectedYear);
            assertThat(actual.getDay()).isEqualTo(expectedDay);
            assertThat(actual.getPart()).isEqualTo(expectedPart);
            assertThat(actual.getResult()).isEqualTo(expectedResult);
        }
    }

    @Nested
    @DisplayName("Day One Part Two Tests")
    class dayOnePartTwoTests {
        @Test
        @DisplayName("calls dayOne.partTwo")
        public void get_CalledWithDay1Part1_CallsExpected() throws IOException {
            underTest.get(new Random().nextInt(), 1, 2);

            verify(mockDayOne).partTwo();
        }

        @Test
        @DisplayName("returns the expected value")
        public void get_Called_ReturnsExpectedValue() throws IOException {
            int expectedYear = new Random().nextInt();
            int expectedDay = 1;
            int expectedPart = 2;
            int expectedResult = new Random().nextInt();
            when(mockDayOne.partTwo()).thenReturn(expectedResult);

            ResponseEntity<AdventOfCodeResponse> response = underTest.get(expectedYear, expectedDay, expectedPart);

            AdventOfCodeResponse actual = response.getBody();
            assertThat(actual.getYear()).isEqualTo(expectedYear);
            assertThat(actual.getDay()).isEqualTo(expectedDay);
            assertThat(actual.getPart()).isEqualTo(expectedPart);
            assertThat(actual.getResult()).isEqualTo(expectedResult);
        }
    }
}