package com.adventofcode.day11;

import com.adventofcode.Solver;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class KeepAway extends Solver {

    private static final Pattern MONKEY_NUM = Pattern.compile(
            "Monkey (\\d):");
    private static final Pattern STARTING_ITEMS = Pattern.compile(
            "  Starting items: (\\d+(, \\d+)*)");
    private static final Pattern OPERATION = Pattern.compile(
            "  Operation: new = (old|\\d+) ([+*]) (old|\\d+)");
    private static final Pattern TEST = Pattern.compile(
            "  Test: divisible by (\\d+)");
    private static final Pattern IF_TRUE = Pattern.compile(
            "    If true: throw to monkey (\\d)");
    private static final Pattern IF_FALSE = Pattern.compile(
            "    If false: throw to monkey (\\d)");

    public KeepAway() {
        super(11);
    }

    @Override
    public String solvePartOne(List<String> lines) {
        return solve(lines, 20, 3);
    }

    @Override
    public String solvePartTwo(List<String> lines) {
        return solve(lines, 10_000, 0);
    }

    private String solve(List<String> lines, int rounds, int relief) {
        Map<Integer, Monkey> monkeys = new HashMap<>();
        long modulus = 1;
        for (int i = 0; i < lines.size(); i++) {

            if (lines.get(i).isEmpty()) i++;

            Matcher monkeyNumMatcher = MONKEY_NUM.matcher(lines.get(i++));
            if (!monkeyNumMatcher.find()) throw new RuntimeException();
            int monkeyNum = parseInt(monkeyNumMatcher.group(1));

            Matcher itemsMatcher = STARTING_ITEMS.matcher(lines.get(i++));
            if (!itemsMatcher.find()) throw new RuntimeException();
            List<Long> items = Arrays.stream(itemsMatcher.group(1).split(", "))
                    .map(Long::parseLong).toList();

            Matcher operationMatcher = OPERATION.matcher(lines.get(i++));
            if (!operationMatcher.find()) throw new RuntimeException();
            String firstStr = operationMatcher.group(1);
            String secondStr = operationMatcher.group(3);
            String op = operationMatcher.group(2);
            UnaryOperator<Long> operation = x -> {
                long first = firstStr.equals("old") ? x : parseLong(firstStr);
                long second = secondStr.equals("old") ? x : parseLong(secondStr);
                return switch (op) {
                    case "+" -> first + second;
                    case "*" -> first * second;
                    default -> throw new UnsupportedOperationException(op);
                };
            };

            Matcher testMatcher = TEST.matcher(lines.get(i++));
            if (!testMatcher.find()) throw new RuntimeException();
            long divisibleBy = parseLong(testMatcher.group(1));
            modulus *= divisibleBy;
            Predicate<Long> test = x -> x % divisibleBy == 0;

            Matcher ifTrueMatcher = IF_TRUE.matcher(lines.get(i++));
            if (!ifTrueMatcher.find()) throw new RuntimeException();
            int ifTrue = parseInt(ifTrueMatcher.group(1));
            Matcher ifFalseMatcher = IF_FALSE.matcher(lines.get(i++));
            if (!ifFalseMatcher.find()) throw new RuntimeException();
            int ifFalse = parseInt(ifFalseMatcher.group(1));

            monkeys.put(monkeyNum, new Monkey(
                    new ArrayDeque<>(items), operation, test, ifTrue, ifFalse));
        }

        long[] inspections = new long[monkeys.size()];

        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < monkeys.size(); j++) {
                Monkey monkey = monkeys.get(j);
                while (!monkey.items().isEmpty()) {
                    inspections[j]++;
                    Long item = monkey.items().removeFirst();
                    item = monkey.operation().apply(item);
                    if (relief != 0) {
                        item /= relief;
                    } else {
                        item %= modulus;
                    }
                    if (monkey.test().test(item)) {
                        monkeys.get(monkey.ifTrue()).items().addLast(item);
                    } else {
                        monkeys.get(monkey.ifFalse()).items().addLast(item);
                    }
                }
            }
        }

        long one = 0L, two = 0L;
        for (long inspection : inspections) {
            if (inspection > one) {
                if (inspection > two) {
                    one = two;
                    two = inspection;
                } else {
                    one = inspection;
                }
            }
        }
        return String.valueOf(one * two);
    }
}

record Monkey(
        Deque<Long> items,
        UnaryOperator<Long> operation,
        Predicate<Long> test,
        int ifTrue, int ifFalse) {}

