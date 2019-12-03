package com.spenserca.adventofcode2019.services;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DayTwoService {
    public int runIntCodeProgram(String program) {
        int[] opCodes = Arrays.stream(program.split(","))
                .mapToInt(Integer::valueOf)
                .toArray();
        int currentPosition = 0;
        int opCode = opCodes[currentPosition];


        while (opCode != 99) {
            int positionOne = opCodes[currentPosition + 1];
            int positionTwo = opCodes[currentPosition + 2];
            int storePosition = opCodes[currentPosition + 3];

            if (opCode == 1) {
                opCodes[storePosition] = opCodes[positionOne] + opCodes[positionTwo];
            } else if (opCode == 2) {
                opCodes[storePosition] = opCodes[positionOne] * opCodes[positionTwo];
            }

            currentPosition += 4;
            opCode = opCodes[currentPosition];
        }


        return opCodes[0];
    }
}
