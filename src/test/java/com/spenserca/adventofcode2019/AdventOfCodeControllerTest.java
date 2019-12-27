package com.spenserca.adventofcode2019;

import com.spenserca.adventofcode2019.days.DayFour;
import com.spenserca.adventofcode2019.days.DayOne;
import com.spenserca.adventofcode2019.days.DayThree;
import com.spenserca.adventofcode2019.days.DayTwo;
import com.spenserca.adventofcode2019.models.AdventOfCodeResponse;
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
    private DayTwo mockDayTwo = mock(DayTwo.class);
    private DayThree mockDayThree = mock(DayThree.class);
    private DayFour mockDayFour = mock(DayFour.class);
    private InputResourceService mockInputResourceService = mock(InputResourceService.class);

    @BeforeEach
    public void setup() throws IOException {
        when(mockDayOne.partOne()).thenReturn(new Random().nextInt());
        when(mockDayOne.partTwo()).thenReturn(new Random().nextInt());
        when(mockDayTwo.partOne()).thenReturn(new Random().nextInt());
        when(mockDayTwo.partTwo()).thenReturn(new int[]{new Random().nextInt()});
        when(mockDayThree.partOne()).thenReturn(new Random().nextInt());
        when(mockDayThree.partTwo()).thenReturn(new Random().nextInt());
        when(mockDayFour.partOne()).thenReturn(new Random().nextInt());
        when(mockDayFour.partTwo()).thenReturn(new Random().nextInt());
        when(mockInputResourceService.getInputForDay(anyInt()))
                .thenReturn(Collections.singletonList(RandomString.make(8)));

        underTest = new AdventOfCodeController(
                mockDayOne,
                mockDayTwo,
                mockDayThree,
                mockDayFour
        );
    }

    @Nested
    @DisplayName("Day One Part One Tests")
    class dayOnePartOneTests {
        @Test
        @DisplayName("calls dayOne.partOne")
        public void get_CalledWithDay1Part_CallsExpected() throws IOException {
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
        public void get_CalledWithPart2_CallsExpected() throws IOException {
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

    @Nested
    @DisplayName("Day Two Part One Tests")
    class dayTwoPartOneTests {
        @Test
        @DisplayName("calls dayTwo.partOne")
        public void get_CalledWithDay2Part1_CallsExpected() throws IOException {
            underTest.get(new Random().nextInt(), 2, 1);

            verify(mockDayTwo).partOne();
        }

        @Test
        @DisplayName("returns the expected value")
        public void get_Called_ReturnsExpectedValue() throws IOException {
            int expectedYear = new Random().nextInt();
            int expectedDay = 2;
            int expectedPart = 1;
            int expectedResult = new Random().nextInt();
            when(mockDayTwo.partOne()).thenReturn(expectedResult);

            ResponseEntity<AdventOfCodeResponse> response = underTest.get(expectedYear, expectedDay, expectedPart);

            AdventOfCodeResponse actual = response.getBody();
            assertThat(actual.getYear()).isEqualTo(expectedYear);
            assertThat(actual.getDay()).isEqualTo(expectedDay);
            assertThat(actual.getPart()).isEqualTo(expectedPart);
            assertThat(actual.getResult()).isEqualTo(expectedResult);
        }
    }

    @Nested
    @DisplayName("Day Two Part Two Tests")
    class dayTwoPartTwoTests {
        @Test
        @DisplayName("calls dayTwo.partTwo")
        public void get_CalledWithDay2Part2_CallsExpected() throws IOException {
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

    @Nested
    @DisplayName("Day Three Part One Tests")
    class dayThreePartOneTests {
        @Test
        @DisplayName("calls dayThree.partOne")
        public void get_CalledWithPart1_CallsExpected() throws IOException {
            underTest.get(new Random().nextInt(), 3, 1);

            verify(mockDayThree).partOne();
        }

        @Test
        @DisplayName("returns the expected value")
        public void get_Called_ReturnsExpectedValue() throws IOException {
            int expectedYear = new Random().nextInt();
            int expectedDay = 3;
            int expectedPart = 1;
            int expectedResult = new Random().nextInt();
            when(mockDayThree.partOne()).thenReturn(expectedResult);

            ResponseEntity<AdventOfCodeResponse> response = underTest.get(expectedYear, expectedDay, expectedPart);

            AdventOfCodeResponse actual = response.getBody();
            assertThat(actual.getYear()).isEqualTo(expectedYear);
            assertThat(actual.getDay()).isEqualTo(expectedDay);
            assertThat(actual.getPart()).isEqualTo(expectedPart);
            assertThat(actual.getResult()).isEqualTo(expectedResult);
        }
    }

    @Nested
    @DisplayName("Day Three Part Two Tests")
    class dayThreePartTwoTests {
        @Test
        @DisplayName("calls dayThree.partTwo")
        public void get_CalledWithPart2_CallsExpected() throws IOException {
            underTest.get(new Random().nextInt(), 3, 2);

            verify(mockDayThree).partTwo();
        }

        @Test
        @DisplayName("returns the expected value")
        public void get_Called_ReturnsExpectedValue() throws IOException {
            int expectedYear = new Random().nextInt();
            int expectedDay = 3;
            int expectedPart = 2;
            int expectedResult = new Random().nextInt();
            when(mockDayThree.partTwo()).thenReturn(expectedResult);

            ResponseEntity<AdventOfCodeResponse> response = underTest.get(expectedYear, expectedDay, expectedPart);

            AdventOfCodeResponse actual = response.getBody();
            assertThat(actual.getYear()).isEqualTo(expectedYear);
            assertThat(actual.getDay()).isEqualTo(expectedDay);
            assertThat(actual.getPart()).isEqualTo(expectedPart);
            assertThat(actual.getResult()).isEqualTo(expectedResult);
        }
    }

    @Nested
    @DisplayName("Day Four Part One Tests")
    class dayFourPartOneTests {
        @Test
        @DisplayName("calls dayFour.partOne")
        public void get_CalledWithPart1_CallsExpected() throws IOException {
            underTest.get(new Random().nextInt(), 4, 1);

            verify(mockDayFour).partOne();
        }

        @Test
        @DisplayName("returns the expected value")
        public void get_Called_ReturnsExpectedValue() throws IOException {
            int expectedYear = new Random().nextInt();
            int expectedDay = 4;
            int expectedPart = 1;
            int expectedResult = new Random().nextInt();
            when(mockDayFour.partOne()).thenReturn(expectedResult);

            ResponseEntity<AdventOfCodeResponse> response = underTest.get(expectedYear, expectedDay, expectedPart);

            AdventOfCodeResponse actual = response.getBody();
            assertThat(actual.getYear()).isEqualTo(expectedYear);
            assertThat(actual.getDay()).isEqualTo(expectedDay);
            assertThat(actual.getPart()).isEqualTo(expectedPart);
            assertThat(actual.getResult()).isEqualTo(expectedResult);
        }
    }

    @Nested
    @DisplayName("Day Four Part Two Tests")
    class dayFourPartTwoTests {
        @Test
        @DisplayName("calls dayFour.partTwo")
        public void get_CalledWithPart2_CallsExpected() throws IOException {
            underTest.get(new Random().nextInt(), 4, 2);

            verify(mockDayFour).partTwo();
        }

        @Test
        @DisplayName("returns the expected value")
        public void get_Called_ReturnsExpectedValue() throws IOException {
            int expectedYear = new Random().nextInt();
            int expectedDay = 4;
            int expectedPart = 2;
            int expectedResult = new Random().nextInt();
            when(mockDayFour.partTwo()).thenReturn(expectedResult);

            ResponseEntity<AdventOfCodeResponse> response = underTest.get(expectedYear, expectedDay, expectedPart);

            AdventOfCodeResponse actual = response.getBody();
            assertThat(actual.getYear()).isEqualTo(expectedYear);
            assertThat(actual.getDay()).isEqualTo(expectedDay);
            assertThat(actual.getPart()).isEqualTo(expectedPart);
            assertThat(actual.getResult()).isEqualTo(expectedResult);
        }
    }
}