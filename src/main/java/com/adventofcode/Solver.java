package com.adventofcode;

import java.util.List;

public abstract class Solver {

    private final int day;

    public Solver(int day) {
        this.day = day;
    }

    public abstract String solvePartOne(List<String> lines);

    public abstract String solvePartTwo(List<String> lines);

    public final String solvePartOne(Problem problem) {
        return solve(problem, 1);
    }

    public final String solvePartTwo(Problem problem) {
        return solve(problem, 2);
    }

    private String solve(Problem problem, int part) {
        List<String> lines = Utils.parseInput(day, problem, 1);
        return switch (part) {
            case 1 -> solvePartOne(lines);
            case 2 -> solvePartTwo(lines);
            default -> throw new IllegalArgumentException();
        };
    }

    public final boolean checkPartOne() {
        return check(1);
    }

    public final boolean checkPartTwo() {
        return check(2);
    }

    private boolean check(int part) {
        String actual = solve(Problem.EXAMPLE, part);
        String expected = Utils.parseExpected(day, part);
        if (expected.equals(actual)) {
            return true;
        } else {
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            return false;
        }
    }

}
