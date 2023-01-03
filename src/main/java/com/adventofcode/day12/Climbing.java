package com.adventofcode.day12;

import com.adventofcode.Solver;

import java.util.List;

public class Climbing extends Solver {

    public Climbing() {
        super(12);
    }

    @Override
    public String solvePartOne(List<String> lines) {
        Problem problem = new Problem(lines);
        Node node = problem.search(problem.getStart());
        return String.valueOf(node.steps());
    }

    @Override
    public String solvePartTwo(List<String> lines) {
        Problem problem = new Problem(lines);
        int min = Integer.MAX_VALUE;
        for (Point start : problem.getStartPoints()) {
            Node node = problem.search(start);
            if (node != null && node.steps() < min) {
                min = node.steps();
            }
        }
        return String.valueOf(min);
    }
}

