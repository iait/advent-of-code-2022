package com.adventofcode.day15;

import com.adventofcode.Solver;

import java.util.*;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

public class BeaconZone extends Solver {

    private static final Pattern pattern = Pattern.compile(
            "Sensor at x=(-?\\d+), y=(-?\\d+): closest beacon is at x=(-?\\d+), y=(-?\\d+)");

    private record Sensor(int x, int y, int distance) {}

    public BeaconZone() {
        super(15);
    }

    @Override
    public String solvePartOne(List<String> lines) {
        int row = parseInt(lines.get(0));
        Set<Integer> freePositions = new HashSet<>();
        Set<Integer> beaconPositions = new HashSet<>();
        for (int i = 1; i < lines.size(); i++) {
            var matcher = pattern.matcher(lines.get(i));
            if (matcher.find()) {
                int sensorX = parseInt(matcher.group(1));
                int sensorY = parseInt(matcher.group(2));
                int beaconX = parseInt(matcher.group(3));
                int beaconY = parseInt(matcher.group(4));
                int sensorBeaconDist = abs(sensorX - beaconX) + abs(sensorY - beaconY);
                int sensorRowDist = abs(sensorY - row);
                if (sensorRowDist <= sensorBeaconDist) {
                    for (int j = 0; j <= sensorBeaconDist - sensorRowDist; j++) {
                        freePositions.add(sensorX + j);
                        freePositions.add(sensorX - j);
                    }
                }
                if (beaconY == row) {
                    beaconPositions.add(beaconX);
                }
            }
        }
        freePositions.removeAll(beaconPositions);
        return String.valueOf(freePositions.size());
    }

    @Override
    public String solvePartTwo(List<String> lines) {
        int max = parseInt(lines.get(0));
        List<Sensor> sensors = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            var matcher = pattern.matcher(lines.get(i));
            if (matcher.find()) {
                int sensorX = parseInt(matcher.group(1));
                int sensorY = parseInt(matcher.group(2));
                int beaconX = parseInt(matcher.group(3));
                int beaconY = parseInt(matcher.group(4));
                int sensorBeaconDist = abs(sensorX - beaconX) + abs(sensorY - beaconY);
                sensors.add(new Sensor(sensorX, sensorY, sensorBeaconDist));
            }
        }
        for (int y = 0; y < max; y++) {
            for (int x = 0; x < max; x++) {
                boolean detected = false;
                for (Sensor sensor : sensors) {
                    if (abs(sensor.x - x) + abs(sensor.y - y) <= sensor.distance) {
                        detected = true;
                        x = sensor.x + sensor.distance - abs(sensor.y - y);
                        break;
                    }
                }
                if (!detected) {
                    return String.valueOf(x * 4_000_000L + y);
                }
            }
        }
        throw new RuntimeException("Not found!");

    }
}