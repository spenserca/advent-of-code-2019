package com.spenserca.adventofcode2019.services;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DayTwoService {
    public int runIntCodeProgram(String initialMemoryState, int noun, int verb) {
        int[] addresses = Arrays.stream(initialMemoryState.split(","))
                .mapToInt(Integer::valueOf)
                .toArray();
        addresses[1] = noun;
        addresses[2] = verb;
        int instructionPointer = 0;
        int opCode = addresses[instructionPointer];


        while (opCode != 99) {
            int parameterOne = addresses[instructionPointer + 1];
            int parameterTwo = addresses[instructionPointer + 2];
            int parameterThree = addresses[instructionPointer + 3];

            if (opCode == 1) {
                addresses[parameterThree] = addresses[parameterOne] + addresses[parameterTwo];
            } else if (opCode == 2) {
                addresses[parameterThree] = addresses[parameterOne] * addresses[parameterTwo];
            }

            instructionPointer += 4;
            opCode = addresses[instructionPointer];
        }


        return addresses[0];
    }
}
