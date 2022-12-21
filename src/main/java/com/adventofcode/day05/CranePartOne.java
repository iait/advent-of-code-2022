package com.adventofcode.day05;

import java.util.*;

public class CranePartOne extends Crane {

    public CranePartOne(List<String> lines, int size) {
        super(lines, size);
    }

    public void move(int num, int from, int to) {
        Deque<Character> fromStack = stacks.get(from - 1);
        Deque<Character> toStack = stacks.get(to - 1);
        for (int i = 0; i < num; i++) {
            toStack.addFirst(fromStack.removeFirst());
        }
    }

}
