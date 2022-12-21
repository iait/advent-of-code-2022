package com.adventofcode.day05;

import com.adventofcode.Solver;

import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

import static java.lang.Integer.parseInt;

public class StackRearrangement extends Solver {

    private static final String PATTERN = "move (\\d+) from (\\d) to (\\d)";

    public StackRearrangement() {
        super(5);
    }

    @Override
    public String solvePartOne(List<String> lines) {
        return solve(lines, CraneFactory.PART_ONE);
    }

    @Override
    public String solvePartTwo(List<String> lines) {
        return solve(lines, CraneFactory.PART_TWO);
    }

    private String solve(List<String> lines, CraneFactory craneFactory) {
        int i = 0;
        while (!lines.get(i).isEmpty()) {
            i++;
        }
        int size = (lines.get(i - 1).length() + 1) / 4;
        Crane crane = craneFactory.createCrane(lines.subList(0, i - 1), size);
        i++;
        while (i < lines.size()) {
            Scanner s = new Scanner(lines.get(i));
            s.findInLine(PATTERN);
            MatchResult result = s.match();
            int num = parseInt(result.group(1));
            int from = parseInt(result.group(2));
            int to = parseInt(result.group(3));
            s.close();
            crane.move(num, from, to);
            i++;
        }
        return crane.getTop();
    }

}
