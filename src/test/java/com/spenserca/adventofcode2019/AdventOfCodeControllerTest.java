package com.spenserca.adventofcode2019;

import com.spenserca.adventofcode2019.services.InputResourceService;
import com.spenserca.adventofcode2019.services.TwentyNineteenDayOneService;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AdventOfCodeControllerTest {
    private AdventOfCodeController underTest;
    private TwentyNineteenDayOneService mockTwentyNineteenDayOneService = mock(TwentyNineteenDayOneService.class);
    private InputResourceService mockInputResourceService = mock(InputResourceService.class);

    @BeforeAll
    public void setup() throws IOException {
        when(mockTwentyNineteenDayOneService.partOne(anyInt()))
                .thenReturn(new Random().nextInt());
        when(mockInputResourceService.getInputForDay(anyInt()))
                .thenReturn(Collections.singletonList(RandomString.make(8)));

        underTest = new AdventOfCodeController(
                mockTwentyNineteenDayOneService,
                mockInputResourceService
        );
    }

    @Test
    public void get_CalledWithYear2019Day1Part1_CallsTwentyNineteenDayOneServicePartOneWithTheExpectedParams() {

    }
}