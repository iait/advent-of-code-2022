package com.adventofcode.day08;

import com.adventofcode.Solver;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Math.max;
import static java.util.Arrays.stream;

public class TreeHouse extends Solver {

    public TreeHouse() {
        super(8);
    }

    @Override
    public String solvePartOne(List<String> lines) {
        int size = lines.size();
        byte[][] trees = new byte[size][size];
        for (int i = 0; i < size; i++) {
            String line = lines.get(i);
            for (int j = 0; j < size; j++) {
                trees[i][j] = (byte) (line.charAt(j) - '0');
            }
        }
        int[][] visible = new int[size][size];
        int count = (size - 1) * 4;
        for (int i = 1; i < size - 1; i++) {
            byte left = trees[i][0];
            byte right = trees[i][size - 1];
            byte top = trees[0][i];
            byte bottom = trees[size - 1][i];
            for (int j = 1; j < size - 1; j++) {
                if (trees[i][j] > left) {
                    left = trees[i][j];
                    visible[i][j] = 1;
                }
                if (trees[i][size - 1 - j] > right) {
                    right = trees[i][size - 1 - j];
                    visible[i][size - 1 - j] = 1;
                }
                if (trees[j][i] > top) {
                    top = trees[j][i];
                    visible[j][i] = 1;
                }
                if (trees[size - 1 - j][i] > bottom) {
                    bottom = trees[size - 1 - j][i];
                    visible[size - 1 - j][i] = 1;
                }
            }
        }
        count += stream(visible).reduce(0,
                (sum, row) -> sum + IntStream.of(row).reduce(0, Integer::sum),
                Integer::sum);
        return String.valueOf(count);
    }

    public String solvePartOneAnotherSolution(List<String> lines) {
        int size = lines.size();
        boolean[][] visible = new boolean[size][size];
        byte[][] trees = new byte[size][size];
        for (int i = 0; i < size; i++) {
            String line = lines.get(i);
            for (int j = 0; j < size; j++) {
                trees[i][j] = (byte) (line.charAt(j) - '0');
            }
        }
        int count = (size - 1) * 4;
        // left to right
        for (int i = 1; i < size - 1; i++) {
            byte tallest = trees[i][0];
            for (int j = 1; j < size - 1; j++) {
                if (trees[i][j] > tallest) {
                    tallest = trees[i][j];
                    if (!visible[i][j]) {
                        visible[i][j] = true;
                        count++;
                    }
                }
            }
        }
        // right to left
        for (int i = 1; i < size - 1; i++) {
            byte tallest = trees[i][size - 1];
            for (int j = size - 2; j > 0; j--) {
                if (trees[i][j] > tallest) {
                    tallest = trees[i][j];
                    if (!visible[i][j]) {
                        visible[i][j] = true;
                        count++;
                    }
                }
            }
        }
        // top to bottom
        for (int i = 1; i < size - 1; i++) {
            byte tallest = trees[0][i];
            for (int j = 1; j < size - 1; j++) {
                if (trees[j][i] > tallest) {
                    tallest = trees[j][i];
                    if (!visible[j][i]) {
                        visible[j][i] = true;
                        count++;
                    }
                }
            }
        }
        // bottom to top
        for (int i = 1; i < size - 1; i++) {
            byte tallest = trees[size - 1][i];
            for (int j = size - 2; j > 0; j--) {
                if (trees[j][i] > tallest) {
                    tallest = trees[j][i];
                    if (!visible[j][i]) {
                        visible[j][i] = true;
                        count++;
                    }
                }
            }
        }
        return String.valueOf(count);
    }

    @Override
    public String solvePartTwo(List<String> lines) {
        int size = lines.size();
        byte[][] trees = new byte[size][size];
        for (int i = 0; i < size; i++) {
            String line = lines.get(i);
            for (int j = 0; j < size; j++) {
                trees[i][j] = (byte) (line.charAt(j) - '0');
            }
        }
        int max = 0, score, dist;
        byte height;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                height = trees[i][j];
                score = 1;
                // left
                dist = 0;
                for (int k = j - 1; k >= 0; k--) {
                    dist++;
                    if (trees[i][k] >= height) break;
                }
                score *= dist;
                if (score == 0) continue;
                // right
                dist = 0;
                for (int k = j + 1; k < size; k++) {
                    dist++;
                    if (trees[i][k] >= height) break;
                }
                score *= dist;
                if (score == 0) continue;
                // top
                dist = 0;
                for (int k = i - 1; k >= 0; k--) {
                    dist++;
                    if (trees[k][j] >= height) break;
                }
                score *= dist;
                if (score == 0) continue;
                // bottom
                dist = 0;
                for (int k = i + 1; k < size; k++) {
                    dist++;
                    if (trees[k][j] >= height) break;
                }
                score *= dist;
                //
                max = max(max, score);
            }
        }
        return String.valueOf(max);
    }

    public String solvePartTwoAnotherSolution(List<String> lines) {
        ScenicScore ss = new ScenicScore(lines);
        int score = ss.getMaxScenicScore();
        return String.valueOf(score);
    }
}
