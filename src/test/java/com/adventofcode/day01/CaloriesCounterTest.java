package com.adventofcode.day01;

import com.adventofcode.Problem;
import com.adventofcode.Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CaloriesCounterTest {

    @Test
    void test() {
        Solver solver = new CalorieCounter();
        Assertions.assertTrue(solver.checkPartOne());
        System.out.println("Part one: " + solver.solvePartOne(Problem.INPUT));
        Assertions.assertTrue(solver.checkPartTwo());
        System.out.println("Part two: " + solver.solvePartTwo(Problem.INPUT));
    }
}
