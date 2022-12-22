package com.adventofcode.day06;

import com.adventofcode.Solver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommunicationDevice extends Solver {

    public CommunicationDevice() {
        super(6);
    }

    @Override
    public String solvePartOne(List<String> lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(findMarker(line, 4) + System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String solvePartTwo(List<String> lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(findMarker(line, 14) + System.lineSeparator());
        }
        return sb.toString();
    }

    private int findMarker(String buffer, int markerLength) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < buffer.length(); i++) {
            if (i - markerLength >= 0) {
                char c = buffer.charAt(i - markerLength);
                Integer occurrences = map.get(c);
                if (occurrences == 1) {
                    map.remove(c);
                } else {
                    map.put(c, occurrences - 1);
                }
            }
            char c = buffer.charAt(i);
            Integer occurrences = map.get(c);
            if (occurrences == null) {
                occurrences = 0;
            }
            map.put(c, occurrences + 1);
            if (map.size() == markerLength) {
                return i + 1;
            }
        }
        throw new RuntimeException("Marker not found");
    }
}
