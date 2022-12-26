package com.adventofcode.day09;

import com.adventofcode.Solver;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.Math.abs;

public class RopeBridge extends Solver {

    private static final Pattern PATTERN = Pattern.compile("([LRUD]) (\\d+)");

    public RopeBridge() {
        super(9);
    }

    @Override
    public String solvePartOne(List<String> lines) {
        List<Motion> motions =
                lines.stream().flatMap(this::generateMotions).toList();
        Set<Point> visited = new HashSet<>();
        Point head = new Point(0, 0);
        Point tail = head;
        visited.add(tail);
        for (Motion motion : motions) {
            head = head.applyMotion(motion);
            tail = moveTail(tail, head);
            visited.add(tail);
        }
        return String.valueOf(visited.size());
    }

    @Override
    public String solvePartTwo(List<String> lines) {
        List<Motion> motions =
                lines.stream().flatMap(this::generateMotions).toList();
        Set<Point> visited = new HashSet<>();
        Point[] knots = new Point[10];
        Arrays.fill(knots, new Point(0, 0));
        visited.add(knots[9]);
        for (Motion motion : motions) {
            knots[0] = knots[0].applyMotion(motion);
            for (int i = 1; i < 10; i++) {
                knots[i] = moveTail(knots[i], knots[i - 1]);
            }
            visited.add(knots[9]);
        }
        return String.valueOf(visited.size());
    }

    Stream<Motion> generateMotions(String line) {
        Matcher matcher = PATTERN.matcher(line);
        if (matcher.find()) {
            Motion motion = Motion.of(matcher.group(1));
            int times = Integer.parseInt(matcher.group(2));
            return Collections.nCopies(times, motion).stream();
        }
        throw new IllegalArgumentException();
    }

    Point moveTail(Point tail, Point head) {
        int distX = head.x() - tail.x();
        int distY = head.y() - tail.y();
        return switch (abs(distX)) {
            case 0 -> switch (abs(distY)) {
                case 0, 1 -> tail;
                case 2 -> new Point(tail.x(), tail.y() + (distY/2));
                default -> throw new IllegalStateException();
            };
            case 1 -> switch (abs(distY)) {
                case 0, 1 -> tail;
                case 2 -> new Point(tail.x() + distX, tail.y() + (distY/2));
                default -> throw new IllegalStateException();
            };
            case 2 -> switch (abs(distY)) {
                case 0 -> new Point(tail.x() + (distX/2), tail.y());
                case 1 -> new Point(tail.x() + (distX/2), tail.y() + distY);
                case 2 -> new Point(tail.x() + (distX/2), tail.y() + (distY/2));
                default -> throw new IllegalStateException();
            };
            default -> throw new IllegalStateException();
        };
    }
}

record Point(int x, int y) {
    Point applyMotion(Motion motion) {
        return switch (motion) {
            case LEFT -> new Point(x - 1, y);
            case RIGHT -> new Point(x + 1, y);
            case UP -> new Point(x, y + 1);
            case DOWN -> new Point(x, y - 1);
        };
    }
}

enum Motion {
    LEFT, RIGHT, UP, DOWN;
    static Motion of(String c) {
        return switch (c) {
            case "L" -> LEFT;
            case "R" -> RIGHT;
            case "U" -> UP;
            case "D" -> DOWN;
            default -> throw new IllegalStateException();
        };
    }
}
