package com.adventofcode.day03;

import com.adventofcode.Solver;

import java.util.List;

public class Rucksack extends Solver {

    public Rucksack() {
        super(3);
    }

    @Override
    public String solvePartOne(List<String> lines) {
        int sum = 0;
        for (String line : lines) {
            sum += getRepetition(line);
        }
        return String.valueOf(sum);
    }

    private int getRepetition(String str) {
        boolean[] numbers = new boolean[52];
        int half = str.length() / 2;
        int repetition = -1;
        for (int i = 0; i < half; i++) {
            numbers[charToNumber(str.charAt(i))] = true;
        }
        for (int i = half; i < str.length(); i++) {
            int number = charToNumber(str.charAt(i));
            if (numbers[number]) {
                repetition = number + 1;
                break;
            }
        }
        if (repetition < 0) {
            throw new RuntimeException("Unexpected");
        }
        return repetition;
    }

    int charToNumber(char c) {
        if (Character.getType(c) == Character.LOWERCASE_LETTER) {
            return c - 'a';
        }
        if (Character.getType(c) == Character.UPPERCASE_LETTER) {
            return c - 'A' + 26;
        }
        throw new IllegalArgumentException("Unexpected character: " + c);
    }

    @Override
    public String solvePartTwo(List<String> lines) {
        int i = 0;
        int sum = 0;
        while (i < lines.size()) {
            byte[] numbers = new byte[52];
            String firstStr = lines.get(i++);
            for (int j = 0; j < firstStr.length(); j++) {
                int number = charToNumber(firstStr.charAt(j));
                if (numbers[number] == 0) {
                    numbers[number] = 1;
                }
            }
            String secondStr = lines.get(i++);
            for (int j = 0; j < secondStr.length(); j++) {
                int number = charToNumber(secondStr.charAt(j));
                if (numbers[number] == 1) {
                    numbers[number] = 2;
                }
            }
            String thirdStr = lines.get(i++);
            for (int j = 0; j < thirdStr.length(); j++) {
                int number = charToNumber(thirdStr.charAt(j));
                if (numbers[number] == 2) {
                    sum += number + 1;
                    break;
                };
            }
        }
        return String.valueOf(sum);
    }
}
