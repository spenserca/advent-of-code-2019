package com.spenserca.adventofcode2019.services;

import org.springframework.stereotype.Component;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;

@Component
public class DayThreeService {
    public int getManhattanDistanceFromClosestIntersection(List<String> wires) {
        Set<SimpleEntry> wireOneCoordinates = getWirePathCoordinates(wires.get(0));
        Set<SimpleEntry> wireTwoCoordinates = getWirePathCoordinates(wires.get(1));
        wireOneCoordinates.retainAll(wireTwoCoordinates);

        return wireOneCoordinates.stream()
            .map((coordinate) -> Math.abs((Integer) coordinate.getKey()) + Math.abs((Integer) coordinate.getValue()))
            .min(Comparator.comparingInt(a -> a))
            .get();
    }

    public int getMinimumStepsToIntersection(List<String> wires) {
        HashMap<SimpleEntry, Integer> stepsToWireOneCoordinates = getWirePathCoordinatesWithSteps(wires.get(0));
        HashMap<SimpleEntry, Integer> stepsToWireTwoCoordinates = getWirePathCoordinatesWithSteps(wires.get(1));
        Set<SimpleEntry> wireOneCoordinates = getCoordinates(stepsToWireOneCoordinates);
        Set<SimpleEntry> wireTwoCoordinates = getCoordinates(stepsToWireTwoCoordinates);
        wireOneCoordinates.retainAll(wireTwoCoordinates);

        return wireOneCoordinates
            .stream()
            .map((coordinate) -> stepsToWireOneCoordinates.get(coordinate) + stepsToWireTwoCoordinates.get(coordinate))
            .min(Comparator.comparingInt(a -> a))
            .get();
    }

    private Set<SimpleEntry> getCoordinates(HashMap<SimpleEntry, Integer> stepsToWireOneCoordinates) {
        return stepsToWireOneCoordinates.keySet();
    }

    private Set<SimpleEntry> getWirePathCoordinates(String wire) {
        Set<SimpleEntry> coordinates = new HashSet<>();
        String[] directions = wire.split(",");
        int x = 0;
        int y = 0;

        for (String direction : directions) {
            int distance = Integer.parseInt(direction.substring(1));

            for (int i = 0; i < distance; i++) {
                if (direction.startsWith("R")) {
                    x++;
                } else if (direction.startsWith("L")) {
                    x--;
                } else if (direction.startsWith("U")) {
                    y++;
                } else if (direction.startsWith("D")) {
                    y--;
                }

                coordinates.add(new SimpleEntry(x, y));
            }
        }

        return coordinates;
    }

    private HashMap<SimpleEntry, Integer> getWirePathCoordinatesWithSteps(String wire) {
        HashMap<SimpleEntry, Integer> stepsToCoordinates = new HashMap<>();
        String[] directions = wire.split(",");
        int steps = 0;
        int x = 0;
        int y = 0;

        for (String direction : directions) {
            int distance = Integer.parseInt(direction.substring(1));

            for (int i = 0; i < distance; i++) {
                steps++;
                if (direction.startsWith("R")) {
                    x++;
                } else if (direction.startsWith("L")) {
                    x--;
                } else if (direction.startsWith("U")) {
                    y++;
                } else if (direction.startsWith("D")) {
                    y--;
                }

                SimpleEntry coordinate = new SimpleEntry(x, y);
                if (!stepsToCoordinates.containsKey(coordinate)) {
                    stepsToCoordinates.put(coordinate, steps);
                } else {
                    int currentCoordinateSteps = stepsToCoordinates.get(coordinate);
                    if (steps < currentCoordinateSteps) {
                        stepsToCoordinates.put(coordinate, steps);
                    }
                }
            }
        }

        return stepsToCoordinates;
    }
}
