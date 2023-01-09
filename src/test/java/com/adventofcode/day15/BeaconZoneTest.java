package com.adventofcode.day15;

import com.adventofcode.Problem;
import com.adventofcode.Solver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeaconZoneTest {

    @Test
    void testPartOne() {
        Solver solver = new BeaconZone();
        assertTrue(solver.checkPartOne());
        System.out.println("Part one: " + solver.solvePartOne(Problem.INPUT));
    }

    @Test
    void testPartTwo() {
        Solver solver = new BeaconZone();
        assertTrue(solver.checkPartTwo());
        System.out.println("Part two: " + solver.solvePartTwo(Problem.INPUT));
    }
}
