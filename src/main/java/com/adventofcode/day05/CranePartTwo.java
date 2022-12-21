package com.adventofcode.day05;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CranePartTwo extends Crane {

    public CranePartTwo(List<String> lines, int size) {
        super(lines, size);
    }

    @Override
    public void move(int num, int from, int to) {
        Deque<Character> fromStack = stacks.get(from - 1);
        Deque<Character> toStack = stacks.get(to - 1);
        Deque<Character> tempStack = new ArrayDeque<>();
        for (int i = 0; i < num; i++) {
            tempStack.addFirst(fromStack.removeFirst());
        }
        for (Character crate : tempStack) {
            toStack.addFirst(crate);
        }
    }

}
