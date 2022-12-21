package com.adventofcode.day02;

import com.adventofcode.Solver;

import java.util.List;

public class RockPaperScissors extends Solver {

    public RockPaperScissors() {
        super(2);
    }

    enum Shape {
        ROCK,
        PAPER,
        SCISSORS;

        int getScore() {
            return ordinal() + 1;
        }
    }

    enum Outcome {
        DRAW(3),
        WON(6),
        LOST(0);

        private final int score;

        Outcome(int score) {
            this.score = score;
        }

        int getScore() {
            return score;
        }
    }

    private Outcome getOutcome(Shape player1, Shape player2) {
        int result = player1.ordinal() - player2.ordinal();
        return Outcome.values()[result < 0 ? 3 + result : result];
    }

    private Shape getShape(Shape other, Outcome wanted) {
        int result = (other.ordinal() + wanted.ordinal()) % 3;
        return Shape.values()[result];
    }
    
    private Shape charToShape(char c) {
        return switch (c) {
            case 'A', 'X' -> Shape.ROCK;
            case 'B', 'Y' -> Shape.PAPER;
            case 'C', 'Z' -> Shape.SCISSORS;
            default -> throw new IllegalArgumentException("Unexpected value: " + c);
        };
    }
    
    private Outcome charToOutcome(char c) {
        return switch (c) {
            case 'X' -> Outcome.LOST;
            case 'Y' -> Outcome.DRAW;
            case 'Z' -> Outcome.WON;
            default -> throw new IllegalArgumentException("Unexpected value: " + c);
        };
    }

    @Override
    public String solvePartOne(List<String> lines) {
        int score = 0;
        for (String line : lines) {
            Shape shape = charToShape(line.charAt(2));
            Shape other = charToShape(line.charAt(0));
            score += shape.getScore() + getOutcome(shape, other).getScore();
        }
        return String.valueOf(score);
    }

    @Override
    public String solvePartTwo(List<String> lines) {
        int score = 0;
        for (String line : lines) {
            Shape other = charToShape(line.charAt(0));
            Outcome outcome = charToOutcome(line.charAt(2));
            score += getShape(other, outcome).getScore() + outcome.getScore();
        }
        return String.valueOf(score);
    }
}
