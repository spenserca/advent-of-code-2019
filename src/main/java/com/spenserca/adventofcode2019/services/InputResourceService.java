package com.spenserca.adventofcode2019.services;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

@Component
public class InputResourceService {
    public List<String> getInputForDay(int day) throws IOException {
        String fileName = getFileNameForDay(day);

        if (day == 4) {
            return Collections.singletonList("125730-579381");
        }

        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        return Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
    }

    private String getFileNameForDay(int day) {
        switch (day) {
            case 1:
                return "day01.txt";
            case 2:
                return "day02.txt";
            case 3:
                return "day03.txt";
            default:
                return "";
        }
    }
}
