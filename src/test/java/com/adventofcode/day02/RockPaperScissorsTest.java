package com.adventofcode.day02;

import com.adventofcode.Problem;
import com.adventofcode.Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RockPaperScissorsTest {

    @Test
    void test() {
        Solver solver = new RockPaperScissors();
        Assertions.assertTrue(solver.checkPartOne());
        System.out.println("Part one: " + solver.solvePartOne(Problem.INPUT));
        Assertions.assertTrue(solver.checkPartTwo());
        System.out.println("Part two: " + solver.solvePartTwo(Problem.INPUT));
    }
}
