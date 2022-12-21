package com.adventofcode.day04;

import com.adventofcode.Problem;
import com.adventofcode.Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CleanupTest {

    @Test
    void testPartOne() {
        Solver solver = new Cleanup();
        assertTrue(solver.checkPartOne());
        System.out.println("Part one: " + solver.solvePartOne(Problem.INPUT));
    }

    @Test
    void testPartTwo() {
        Solver solver = new Cleanup();
        assertTrue(solver.checkPartTwo());
        System.out.println("Part two: " + solver.solvePartTwo(Problem.INPUT));
    }

}
