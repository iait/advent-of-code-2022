package com.adventofcode.day04;

import com.adventofcode.Solver;

import java.util.List;

public class Cleanup extends Solver {

    public Cleanup() {
        super(4);
    }

    @Override
    public String solvePartOne(List<String> lines) {
        int sum = 0;
        for (String line : lines) {
            String[] parts = line.split("[-,]");
            int from1 = Integer.parseInt(parts[0]);
            int to1 = Integer.parseInt(parts[1]);
            int from2 = Integer.parseInt(parts[2]);
            int to2 = Integer.parseInt(parts[3]);
            if (from1 == from2) {
                sum++;
            } else if (from1 < from2) {
                if (to1 >= to2) {
                    // ...from1...from2...to2...to1
                    sum++;
                }
            } else {
                if (to1 <= to2) {
                    // ...from2...from1...to1...to2
                    sum++;
                }
            }
        }
        return String.valueOf(sum);
    }

    @Override
    public String solvePartTwo(List<String> lines) {
        int sum = 0;
        for (String line : lines) {
            String[] parts = line.split("[-,]");
            int from1 = Integer.parseInt(parts[0]);
            int to1 = Integer.parseInt(parts[1]);
            int from2 = Integer.parseInt(parts[2]);
            int to2 = Integer.parseInt(parts[3]);
            if (from1 == from2) {
                sum++;
            } else if (from1 < from2) {
                if (from2 <= to1) {
                    sum++;
                } // else: ...from1...to1...from2...to2
            } else {
                if (from1 <= to2) {
                    sum++;
                } // else: ...from2...to2...from1...to1
            }
        }
        return String.valueOf(sum);
    }
}
