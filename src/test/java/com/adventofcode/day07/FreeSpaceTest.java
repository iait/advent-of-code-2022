package com.adventofcode.day07;

import com.adventofcode.Problem;
import com.adventofcode.Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FreeSpaceTest {

    @Test
    void testPartOne() {
        Solver solver = new FreeSpace();
        assertTrue(solver.checkPartOne());
        System.out.println("Part one: " + solver.solvePartOne(Problem.INPUT));
    }

    @Test
    void testPartTwo() {
        Solver solver = new FreeSpace();
        assertTrue(solver.checkPartTwo());
        System.out.println("Part two: " + solver.solvePartTwo(Problem.INPUT));
    }
}
