package com.adventofcode.day01;

import com.adventofcode.Solver;

import java.util.List;
import java.util.stream.IntStream;

public class CalorieCounter extends Solver {

    public CalorieCounter() {
        super(1);
    }

    @Override
    public String solvePartOne(List<String> lines) {
        int maxCalories = 0;
        for (int i = 0; i < lines.size(); i++) {
            String line;
            int calories = 0;
            while (i < lines.size() && !(line = lines.get(i)).isEmpty()) {
                calories += Integer.parseInt(line);
                i++;
            }
            if (calories > maxCalories) {
                maxCalories = calories;
            }
        }
        return String.valueOf(maxCalories);
    }

    @Override
    public String solvePartTwo(List<String> lines) {
        return String.valueOf(topN(lines, 3));
    }

    private int topN(List<String> lines, int n) {
        int[] top = new int[n];
        for (int i = 0; i < lines.size(); i++) {
            String line;
            int calories = 0;
            while (i < lines.size() && !(line = lines.get(i)).isEmpty()) {
                calories += Integer.parseInt(line);
                i++;
            }
            int position = -1;
            for (int j = 0; j < n; j++) {
                if (calories > top[j]) {
                    position = j;
                    break;
                }
            }
            if (position >= 0) {
                System.arraycopy(top, position, top, position + 1, n - 1 - position);
                top[position] = calories;
            }
        }
        return IntStream.of(top).sum();
    }
}
