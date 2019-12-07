package com.spenserca.adventofcode2019.services;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ValidationService Tests")
public class ValidationServiceTest {
    private ValidationService underTest = new ValidationService();

    @Nested
    @DisplayName("isSixDigits Tests")
    class sixDigitsTests {
        @Test
        public void isSixDigits_CalledWithSixDigitValue_ReturnsTrue() {
            String sixDigits = RandomString.make(6);

            boolean actual = underTest.isSixDigits(sixDigits);

            assertThat(actual).isTrue();
        }

        @Test
        public void isSixDigits_CalledWithValueGreaterThanSixDigits_ReturnsFalse() {
            String greaterThanSixDigits = RandomString.make() + RandomString.make(6) + RandomString.make();

            boolean actual = underTest.isSixDigits(greaterThanSixDigits);

            assertThat(actual).isFalse();
        }

        @Test
        public void isSixDigits_CalledWithValueLessThanSixDigits_ReturnsFalse() {
            String lessThanSixDigits = RandomString.make(6).substring(0, new Random().nextInt(4));

            boolean actual = underTest.isSixDigits(lessThanSixDigits);

            assertThat(actual).isFalse();
        }
    }

    @Nested
    @DisplayName("isWithinRange Tests")
    class isWithinRangeTests {
        @Test
        public void isWithinRange_CalledWithValueInRange_ReturnsTrue() {
            int lowerBound = new Random().nextInt();
            int upperBound = lowerBound + 2;
            int withinRange = lowerBound + 1;

            boolean actual = underTest.isWithinRange(lowerBound, upperBound, withinRange);

            assertThat(actual).isTrue();
        }

        @Test
        public void isWithinRange_CalledWithValueOfLowerBound_ReturnsTrue() {
            int lowerBound = new Random().nextInt();
            int upperBound = lowerBound + 2;
            int withinRange = lowerBound;

            boolean actual = underTest.isWithinRange(lowerBound, upperBound, withinRange);

            assertThat(actual).isTrue();
        }

        @Test
        public void isWithinRange_CalledWithValueOfUpperBound_ReturnsTrue() {
            int lowerBound = new Random().nextInt();
            int upperBound = lowerBound + 2;
            int withinRange = upperBound;

            boolean actual = underTest.isWithinRange(lowerBound, upperBound, withinRange);

            assertThat(actual).isTrue();
        }

        @Test
        public void isWithinRange_CalledWithValueLessThanLowerBound_ReturnsFalse() {
            int lowerBound = new Random().nextInt();
            int upperBound = lowerBound + 2;
            int withinRange = lowerBound - 1;

            boolean actual = underTest.isWithinRange(lowerBound, upperBound, withinRange);

            assertThat(actual).isFalse();
        }

        @Test
        public void isWithinRange_CalledWithValueGreaterThanUpperBound_ReturnsFalse() {
            int lowerBound = new Random().nextInt();
            int upperBound = lowerBound + 2;
            int withinRange = upperBound + 1;

            boolean actual = underTest.isWithinRange(lowerBound, upperBound, withinRange);

            assertThat(actual).isFalse();
        }
    }

    @Nested
    @DisplayName("hasMatchingAdjacentValues Tests")
    class hasAdjacentValuesTests {
        @Test
        public void hasMatchingAdjacentValues_CalledWithValueWithMatchingAdjacentValues_ReturnsTrue() {
            String value = RandomString.make(1);
            String hasMatchingAdjacentValues = RandomString.make(5) + value + value + RandomString.make();

            boolean actual = underTest.hasMatchingAdjacentValues(hasMatchingAdjacentValues);

            assertThat(actual).isTrue();
        }

        @Test
        public void hasMatchingAdjacentValues_CalledWithValueWithoutMatchingAdjacentValues_ReturnsFalse() {
            String[] valuesOne = new String[]{"a", "b", "c", "d"};
            int valueOneIndex = new Random().nextInt(3);
            String valueOne = valuesOne[valueOneIndex];
            String[] valuesTwo = new String[]{"e", "f", "g", "h"};
            int valueTwoIndex = new Random().nextInt(3);
            String valueTwo = valuesTwo[valueTwoIndex];
            String hasNoMatchingAdjacentValues = valueOne + valueTwo;

            boolean actual = underTest.hasMatchingAdjacentValues(hasNoMatchingAdjacentValues);

            assertThat(actual).isFalse();
        }

        @Test
        public void hasMatchingAdjacentValues_CalledWithGivenInput123789_ReturnsFalse() {
            String given = "123789";

            boolean actual = underTest.hasMatchingAdjacentValues(given);

            assertThat(actual).isFalse();
        }
    }

    @Nested
    @DisplayName("hasIncreasingValuesOnly Tests")
    class hasIncreasingValuesOnlyTests {
        @Test
        public void hasIncreasingValuesOnly_CalledWithValueWithIncreasingValuesOnly_ReturnsTrue() {
            int startInt = new Random().nextInt(5);
            String start = String.valueOf(startInt);
            String incrementedByOne = String.valueOf(startInt + 1);
            String incrementedByTwo = String.valueOf(startInt + 2);
            String hasIncreasingValuesOnly = start + incrementedByOne + incrementedByTwo;

            boolean actual = underTest.hasIncreasingValuesOnly(hasIncreasingValuesOnly);

            assertThat(actual).isTrue();
        }

        @Test
        public void hasIncreasingValuesOnly_CalledWithValueWithRepeatedValues_ReturnsTrue() {
            int startInt = new Random().nextInt(5);
            String start = String.valueOf(startInt);
            String incrementedByOne = String.valueOf(startInt + 1);
            String hasIncreasingValuesOnly = start + incrementedByOne + incrementedByOne;

            boolean actual = underTest.hasIncreasingValuesOnly(hasIncreasingValuesOnly);

            assertThat(actual).isTrue();
        }

        @Test
        public void hasIncreasingValuesOnly_CalledWithValueWithDescendingValuesOnly_ReturnsFalse() {
            int startInt = new Random().nextInt(5);
            String start = String.valueOf(startInt);
            String incrementedByOne = String.valueOf(startInt + 1);
            String incrementedByTwo = String.valueOf(startInt + 2);
            String hasIncreasingValuesOnly = start + incrementedByTwo + incrementedByOne;

            boolean actual = underTest.hasIncreasingValuesOnly(hasIncreasingValuesOnly);

            assertThat(actual).isFalse();
        }

        @Test
        public void hasIncreasingValuesOnly_CalledWithGivenInput111111_ReturnsTrue() {
            String given = "111111";

            boolean actual = underTest.hasIncreasingValuesOnly(given);

            assertThat(actual).isTrue();
        }

        @Test
        public void hasIncreasingValuesOnly_CalledWithGivenInput223450_ReturnsFalse() {
            String given = "223450";

            boolean actual = underTest.hasIncreasingValuesOnly(given);

            assertThat(actual).isFalse();
        }
    }
}