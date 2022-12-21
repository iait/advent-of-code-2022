package com.adventofcode.day05;

import java.util.*;

public abstract class Crane {

    protected final List<Deque<Character>> stacks;

    public Crane(List<String> lines, int size) {
        this.stacks = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            stacks.add(new ArrayDeque<>());
        }
        for (int i = lines.size() - 1; i >= 0; i--) {
            String line = lines.get(i);
            for (int j = 0; j < size; j++) {
                char c = line.charAt(j * 4 + 1);
                if (c != ' ') {
                    stacks.get(j).addFirst(c);
                }
            }
        }
    }

    public abstract void move(int num, int from, int to);

    public String getTop() {
        StringBuilder sb = new StringBuilder();
        for (Queue<Character> stack : stacks) {
            sb.append(stack.peek());
        }
        return sb.toString();
    }

}
