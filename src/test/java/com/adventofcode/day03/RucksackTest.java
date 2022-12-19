package com.adventofcode.day03;

import com.adventofcode.Problem;
import com.adventofcode.Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RucksackTest {

    @Test
    void testCharToNumber() {
        var r = new Rucksack();
        assertEquals(0, r.charToNumber('a'));
        assertEquals(25, r.charToNumber('z'));
        assertEquals(26, r.charToNumber('A'));
        assertEquals(51, r.charToNumber('Z'));
    }


    @Test
    void test() {
        Solver solver = new Rucksack();
        Assertions.assertTrue(solver.checkPartOne());
        System.out.println("Part one: " + solver.solvePartOne(Problem.INPUT));
        Assertions.assertTrue(solver.checkPartTwo());
        System.out.println("Part two: " + solver.solvePartTwo(Problem.INPUT));
    }
}
