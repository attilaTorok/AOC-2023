package dev.attilatorok;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Day2_1 {

    public static final int MAX_RED = 12;
    public static final int MAX_GREEN = 13;
    public static final int MAX_BLUE = 14;

    public boolean isGamePossible(String sets) {
        boolean result = false;

        String[] subsets = sets.split(";");
        for (String subset : subsets) {
            String[] elements = subset.split(",");
            for (int i = 0; i < elements.length; i++) {
                String[] element = elements[i].trim().split(" ");
                result = switch (element[1]) {
                    case "green" -> Integer.parseInt(element[0]) <= MAX_GREEN;
                    case "blue" -> Integer.parseInt(element[0]) <= MAX_BLUE;
                    case "red" -> Integer.parseInt(element[0]) <= MAX_RED;
                    default -> throw new NoSuchElementException();
                };

                if (!result) {
                    return false;
                }
            }
        }

        return result;
    }

    public int getAnswer(BufferedReader reader) throws IOException {
        int sum = 0;
        String line;

        while ((line = reader.readLine()) != null) {
            String[] split = line.split(":");
            if (isGamePossible(split[1])) {
                sum += Integer.parseInt(split[0].trim().split(" ")[1]);
            }
        }

        return sum;
    }

}
