package com.adventofcode.day09;

import com.adventofcode.Problem;
import com.adventofcode.Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RopeBridgeTest {

    @Test
    void testTailMoves() {
        RopeBridge rb = new RopeBridge();
        Point tail = new Point(0, 0);
        /*
         * ..H..
         * .....
         * H.T.H
         * .....
         * ..H..
         */
        assertEquals(new Point(0, 1), rb.moveTail(tail, new Point(0, 2)));
        assertEquals(new Point(1, 0), rb.moveTail(tail, new Point(2, 0)));
        assertEquals(new Point(0, -1), rb.moveTail(tail, new Point(0, -2)));
        assertEquals(new Point(-1, 0), rb.moveTail(tail, new Point(-2, 0)));
        /*
         * .H.H.
         * .....
         * ..T..
         * .....
         * .H.H.
         */
        assertEquals(new Point(-1, 1), rb.moveTail(tail, new Point(-1, 2)));
        assertEquals(new Point(1, 1), rb.moveTail(tail, new Point(1, 2)));
        assertEquals(new Point(-1, -1), rb.moveTail(tail, new Point(-1, -2)));
        assertEquals(new Point(1, -1), rb.moveTail(tail, new Point(1, -2)));
        /*
         * .....
         * H...H
         * ..T..
         * H...H
         * .....
         */
        assertEquals(new Point(-1, 1), rb.moveTail(tail, new Point(-2, 1)));
        assertEquals(new Point(1, 1), rb.moveTail(tail, new Point(2, 1)));
        assertEquals(new Point(-1, -1), rb.moveTail(tail, new Point(-2, -1)));
        assertEquals(new Point(1, -1), rb.moveTail(tail, new Point(2, -1)));
        /*
         * H...H
         * .....
         * ..T..
         * .....
         * H...H
         */
        assertEquals(new Point(-1, 1), rb.moveTail(tail, new Point(-2, 2)));
        assertEquals(new Point(1, 1), rb.moveTail(tail, new Point(2, 2)));
        assertEquals(new Point(-1, -1), rb.moveTail(tail, new Point(-2, -2)));
        assertEquals(new Point(1, -1), rb.moveTail(tail, new Point(2, -2)));
        /*
         * .....
         * .H.H.
         * ..T..
         * .H.H.
         * .....
         */
        assertEquals(tail, rb.moveTail(tail, new Point(-1, 1)));
        assertEquals(tail, rb.moveTail(tail, new Point(1, 1)));
        assertEquals(tail, rb.moveTail(tail, new Point(-1, -1)));
        assertEquals(tail, rb.moveTail(tail, new Point(1, -1)));
        /*
         * .....
         * ..H..
         * .HTH.
         * ..H..
         * .....
         */
        assertEquals(tail, rb.moveTail(tail, new Point(0, 1)));
        assertEquals(tail, rb.moveTail(tail, new Point(1, 0)));
        assertEquals(tail, rb.moveTail(tail, new Point(0, -1)));
        assertEquals(tail, rb.moveTail(tail, new Point(-1, 0)));
        /*
         * .....
         * .....
         * ..H.. (H covers T)
         * .....
         * .....
         */
        assertEquals(tail, rb.moveTail(tail, new Point(0, 0)));
    }

    @Test
    void testPartOne() {
        Solver solver = new RopeBridge();
        assertTrue(solver.checkPartOne());
        System.out.println("Part one: " + solver.solvePartOne(Problem.INPUT));
    }

    @Test
    void testPartTwo() {
        Solver solver = new RopeBridge();
        assertTrue(solver.checkPartTwo());
        System.out.println("Part two: " + solver.solvePartTwo(Problem.INPUT));
    }
}
