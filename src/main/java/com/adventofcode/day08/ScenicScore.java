package com.adventofcode.day08;

import java.util.List;

public class ScenicScore {

    private final byte[][] trees;
    private final byte[][] left;
    private final byte[][] right;
    private final byte[][] top;
    private final byte[][] bottom;
    private final int size;

    public ScenicScore(List<String> lines) {
        this.size = lines.size();
        this.trees = new byte[size][size];
        for (int i = 0; i < size; i++) {
            String line = lines.get(i);
            for (int j = 0; j < size; j++) {
                trees[i][j] = (byte) (line.charAt(j) - '0');
            }
        }
        this.left = new byte[size][size];
        this.right = new byte[size][size];
        this.top = new byte[size][size];
        this.bottom = new byte[size][size];
    }

    public int getMaxScenicScore() {
        computeLeftViewingDistance();
        computeRightViewingDistance();
        computeTopViewingDistance();
        computeBottomViewingDistance();
        int max = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int score = left[i][j] * right[i][j] * top[i][j] * bottom[i][j];
                if (score > max) {
                    max = score;
                }
            }
        }
        return max;
    }

    public void computeLeftViewingDistance() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                byte height = trees[i][j];
                byte dist = 0;
                for (int k = j - 1; k >= 0; k--) {
                    dist++;
                    if (trees[i][k] >= height) {
                        break;
                    }
                }
                left[i][j] = dist;
            }
        }
    }

    public void computeRightViewingDistance() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                byte height = trees[i][j];
                byte dist = 0;
                for (int k = j + 1; k < size; k++) {
                    dist++;
                    if (trees[i][k] >= height) {
                        break;
                    }
                }
                right[i][j] = dist;
            }
        }
    }

    public void computeTopViewingDistance() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                byte height = trees[j][i];
                byte dist = 0;
                for (int k = j - 1; k >= 0; k--) {
                    dist++;
                    if (trees[k][i] >= height) {
                        break;
                    }
                }
                top[j][i] = dist;
            }
        }
    }

    public void computeBottomViewingDistance() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                byte height = trees[j][i];
                byte dist = 0;
                for (int k = j + 1; k < size; k++) {
                    dist++;
                    if (trees[k][i] >= height) {
                        break;
                    }
                }
                bottom[j][i] = dist;
            }
        }
    }

}
