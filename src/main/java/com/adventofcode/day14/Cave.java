package com.adventofcode.day14;

import java.util.List;

import static java.lang.Integer.parseInt;

public class Cave {

    private byte[][] map;
    private Integer maxY;

    public Cave(List<String> lines) {
        for (String line : lines) {
            String[] points = line.split(" -> ");
            for (String point : points) {
                String[] coordinates = point.split(",");
                int y = parseInt(coordinates[1]);
                if (maxY == null || y > maxY) {
                    maxY = y;
                }
            }
        }
        map = new byte[maxY + 3][1000];
        for (int x = 0; x < 1000; x++) {
            map[maxY + 2][x] = 1;
        }
        for (String line : lines) {
            String[] points = line.split(" -> ");
            String[] coordinates = points[0].split(",");
            int fromX = parseInt(coordinates[0]);
            int fromY = parseInt(coordinates[1]);
            map[fromY][fromX] = 1;
            for (int i = 1; i < points.length; i++) {
                coordinates = points[i].split(",");
                int toX = parseInt(coordinates[0]);
                int toY = parseInt(coordinates[1]);
                if (toX == fromX) {
                    int step = (toY > fromY) ? 1 : -1;
                    for (int y = fromY + step; y != toY + step; y += step) {
                        map[y][toX] = 1;
                    }
                } else if (toY == fromY) {
                    int step = (toX > fromX) ? 1 : -1;
                    for (int x = fromX + step; x != toX + step; x += step) {
                        map[toY][x] = 1;
                    }
                } else {
                    throw new IllegalStateException("Unexpected state");
                }
                fromX = toX;
                fromY = toY;
            }
        }
    }

    public int partOne() {
        int count = 0;
        int x, y;
        boolean rest;
        do {
            x = 500; y = 0; rest = false;
            while (y < maxY && !rest) {
                // move sand one step
                if (map[y + 1][x] == 0) {
                    y++;
                } else if (map[y + 1][x - 1] == 0) {
                    x--;
                    y++;
                } else if (map[y + 1][x + 1] == 0) {
                    x++;
                    y++;
                } else {
                    rest = true;
                    map[y][x] = 2;
                    count++;
                }
            }
        } while (y < maxY);
        return count;
    }

    public int partTwo() {
        int count = 0;
        int x, y;
        boolean rest;
        do {
            x = 500; y = 0; rest = false;
            while (!rest) {
                // move sand one step
                if (map[y + 1][x] == 0) {
                    y++;
                } else if (map[y + 1][x - 1] == 0) {
                    x--;
                    y++;
                } else if (map[y + 1][x + 1] == 0) {
                    x++;
                    y++;
                } else {
                    rest = true;
                    map[y][x] = 2;
                    count++;
                }
            }
        } while (y > 0);
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (byte[] row : map) {
            for (byte b : row) {
                char c = switch (b) {
                    case 0 -> '.';
                    case 1 -> '#';
                    case 2 -> 'o';
                    default -> throw new IllegalStateException(
                            "Unexpected value: " + b);
                };
                sb.append(c);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
