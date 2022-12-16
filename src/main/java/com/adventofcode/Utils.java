package com.adventofcode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Utils {

    public static final String FILE_NAME_FORMAT = "day%02d\\%s%d.txt";

    public static List<String> parseInput(int day, Problem problem, int part) {
        try {
            String file = String.format(FILE_NAME_FORMAT, day, problem.name().toLowerCase(), part);
            Path path = Paths.get(ClassLoader.getSystemResource(file).toURI());
            return Files.readAllLines(path);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int parseExpected(int day, int part) {
        try {
            String file = String.format(FILE_NAME_FORMAT, day, "expected", part);
            Path path = Paths.get(ClassLoader.getSystemResource(file).toURI());
            String expected = Files.readString(path);
            return Integer.parseInt(expected);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
