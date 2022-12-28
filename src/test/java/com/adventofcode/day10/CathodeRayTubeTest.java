package com.adventofcode.day10;

import com.adventofcode.Problem;
import com.adventofcode.Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CathodeRayTubeTest {

    @Test
    void testPartOne() {
        Solver solver = new CathodeRayTube();
        assertTrue(solver.checkPartOne());
        System.out.println("Part one: " + solver.solvePartOne(Problem.INPUT));
    }

    @Test
    void testPartTwo() {
        Solver solver = new CathodeRayTube();
        assertTrue(solver.checkPartTwo());
        System.out.println("Part two: ");
        System.out.println(solver.solvePartTwo(Problem.INPUT));
    }
}
