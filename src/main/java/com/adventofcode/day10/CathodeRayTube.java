package com.adventofcode.day10;

import com.adventofcode.Solver;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.Math.abs;

public class CathodeRayTube extends Solver {

    public CathodeRayTube() {
        super(10);
    }

    @Override
    public String solvePartOne(List<String> lines) {
        List<Instruction> instructions =
                lines.stream().flatMap(this::generateInstruction).toList();
        int sum = 0;
        int check = 20;
        int x = 1;
        int i = 0;
        while (i < instructions.size()) {
            Instruction instruction = instructions.get(i++);
            if (i == check) {
                sum += x * check;
                check += 40;
            }
            switch (instruction.op()) {
                case NOOP -> {}
                case ADD -> x += instruction.value();
            }
        }
        return String.valueOf(sum);
    }

    @Override
    public String solvePartTwo(List<String> lines) {
        List<Instruction> instructions =
                lines.stream().flatMap(this::generateInstruction).toList();
        StringBuilder sb = new StringBuilder();
        int check = 1;
        int x = 1;
        int i = 0;
        while (i < instructions.size()) {
            Instruction instruction = instructions.get(i);
            if (abs(i - (check - 1) * 40 - x) <= 1) {
                sb.append('#');
            } else {
                sb.append('.');
            }
            i++;
            if (i == check * 40) {
                sb.append(System.lineSeparator());
                check++;
            }
            switch (instruction.op()) {
                case NOOP -> {}
                case ADD -> x += instruction.value();
            }
        }
        return sb.toString();
    }

    private Stream<Instruction> generateInstruction(String line) {
        if (line.matches("noop")) {
            return Stream.of(new Instruction(Operation.NOOP, null));
        } else {
            Matcher matcher = Pattern.compile("addx (-?\\d+)").matcher(line);
            if (matcher.find()) {
                Integer value = Integer.valueOf(matcher.group(1));
                return Stream.of(
                        new Instruction(Operation.NOOP, null),
                        new Instruction(Operation.ADD, value));
            }
        }
        throw new IllegalArgumentException();
    }
}

record Instruction(Operation op, Integer value) {}

enum Operation { ADD, NOOP }
