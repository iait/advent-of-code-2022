package com.adventofcode.day07;

import com.adventofcode.Solver;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class FreeSpace extends Solver {

    private static final String BACK_DIRECTORY = "\\$ cd \\.\\.";
    private static final String CHANGE_ROOT_DIRECTORY = "\\$ cd /";
    private static final String CHANGE_DIRECTORY = "\\$ cd .*";
    private static final String LIST_DIRECTORY = "\\$ ls";
    private static final String FILE = "(\\d+) .*";
    private static final Pattern FILE_PATTERN = compile(FILE);

    public FreeSpace() {
        super(7);
    }

    private int sum;
    private SortedSet<Integer> sizes;

    @Override
    public String solvePartOne(List<String> lines) {
        sum = 0;
        sizes = new TreeSet<>();
        Deque<String> stack = new ArrayDeque<>(lines);
        if (!stack.removeFirst().matches(CHANGE_ROOT_DIRECTORY)) {
            throw new RuntimeException("Expecting change to root directory");
        }
        directorySize(stack);
        return String.valueOf(sum);
    }

    @Override
    public String solvePartTwo(List<String> lines) {
        sizes = new TreeSet<>();
        Deque<String> stack = new ArrayDeque<>(lines);
        if (!stack.removeFirst().matches(CHANGE_ROOT_DIRECTORY)) {
            throw new RuntimeException("Expecting change to root directory");
        }
        int used = directorySize(stack);
        int needed = used - 40_000_000;
        Integer result = sizes.tailSet(needed).first();
        return result.toString();
    }

    private int directorySize(Deque<String> lines) {
        if (!lines.removeFirst().matches(LIST_DIRECTORY)) {
            throw new RuntimeException("Expecting list command");
        }
        int size = 0;
        String line;
        while (!lines.isEmpty() && !(line = lines.removeFirst()).matches(BACK_DIRECTORY)) {
            Matcher fileMatcher = FILE_PATTERN.matcher(line);
            if (fileMatcher.find()) {
                size += Integer.parseInt(fileMatcher.group(1));
            } else if (line.matches(CHANGE_DIRECTORY)) {
                size += directorySize(lines);
            }
        }
        sizes.add(size);
        if (size <= 100_000) {
            sum += size;
        }
        return size;
    }
}
