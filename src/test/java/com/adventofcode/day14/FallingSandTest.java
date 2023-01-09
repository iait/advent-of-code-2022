package com.adventofcode.day14;

import com.adventofcode.Problem;
import com.adventofcode.Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FallingSandTest {

    @Test
    void testPartOne() {
        Solver solver = new FallingSand();
        assertTrue(solver.checkPartOne());
        System.out.println("Part one: " + solver.solvePartOne(Problem.INPUT));
    }

    @Test
    void testPartTwo() {
        Solver solver = new FallingSand();
        assertTrue(solver.checkPartTwo());
        System.out.println("Part two: " + solver.solvePartTwo(Problem.INPUT));
    }
}
