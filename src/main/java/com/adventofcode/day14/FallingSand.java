package com.adventofcode.day14;

import com.adventofcode.Solver;

import java.util.List;

public class FallingSand extends Solver {

    public FallingSand() {
        super(14);
    }

    @Override
    public String solvePartOne(List<String> lines) {
        var cave = new Cave(lines);
//        System.out.println(cave);
        int count = cave.partOne();
//        System.out.println(cave);
        return String.valueOf(count);
    }

    @Override
    public String solvePartTwo(List<String> lines) {
        var cave = new Cave(lines);
//        System.out.println(cave);
        int count = cave.partTwo();
//        System.out.println(cave);
        return String.valueOf(count);
    }

}
