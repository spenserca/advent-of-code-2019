package com.spenserca.adventofcode2019.services;

import org.springframework.stereotype.Component;

import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DayThreeService {
    public int getManhattanDistanceFromClosestIntersection(List<String> wires) {
        Set<SimpleEntry> wireOneCoordinates = getWirePathCoordinates(wires.get(0));
        Set<SimpleEntry> wireTwoCoordinates = getWirePathCoordinates(wires.get(1));
        wireOneCoordinates.retainAll(wireTwoCoordinates);

        return wireOneCoordinates.stream()
                .map((coord) -> Math.abs((Integer) coord.getKey()) + Math.abs((Integer) coord.getValue()))
                .min(Comparator.comparingInt(a -> a))
                .get();
    }

    private Set<SimpleEntry> getWirePathCoordinates(String wire) {
        Set<SimpleEntry> coordinates = new HashSet<>();
        String[] directions = wire.split(",");
        int x = 0;
        int y = 0;

        for (String direction : directions) {
            int distance = Integer.valueOf(direction.substring(1));

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
}
