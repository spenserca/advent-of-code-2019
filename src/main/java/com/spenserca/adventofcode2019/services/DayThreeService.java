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
        Set<SimpleEntry> commonCoordinates = new HashSet<>(wireOneCoordinates);
        commonCoordinates.retainAll(wireTwoCoordinates);

        return commonCoordinates.stream()
                .map((coord) -> Math.abs((int) coord.getKey()) + Math.abs((int) coord.getValue()))
                .min(Comparator.comparingInt(a -> a))
                .get();
    }

    private Set<SimpleEntry> getWirePathCoordinates(String wire) {
        Set<SimpleEntry> coordinates = new HashSet<>();
        SimpleEntry origin = new SimpleEntry(0, 0);
        coordinates.add(origin);
        String[] directions = wire.split(",");
        int x = 0;
        int y = 0;

        for (String d : directions) {
            int distance = Integer.valueOf(d.substring(1));
            char direction = d.charAt(0);

            for (int i = 0; i < distance; i++) {
                if ("R".equals(direction)) {
                    x++;
                } else if ("L".equals(direction)) {
                    x--;
                } else if ("U".equals(direction)) {
                    y++;
                } else if ("D".equals(direction)) {
                    y--;
                }

                coordinates.add(new SimpleEntry(x, y));
            }
        }

        return coordinates;
    }
}
