package dev.attilatorok;

import java.io.BufferedReader;
import java.util.NoSuchElementException;

public class Day2_2 {

    public Cube getLeastNumberOfCubes(String sets) {
        int red = 0, green = 0, blue = 0;

        String[] subsets = sets.split(";");
        for (String subset : subsets) {
            String[] elements = subset.split(",");
            for (String actualElements : elements) {
                String[] element = actualElements.trim().split(" ");
                switch (element[1]) {
                    case "green" -> green = Math.max(Integer.parseInt(element[0]), green);
                    case "blue" -> blue = Math.max(Integer.parseInt(element[0]), blue);
                    case "red" -> red = Math.max(Integer.parseInt(element[0]), red);
                    default -> throw new NoSuchElementException();
                }
            }
        }

        return new Cube(red, green, blue);
    }

    public int getPowerOfCubesInGames(BufferedReader reader) {
        int sum = 0;

        return sum;
    }

    public record Cube(int red, int green, int blue) {}

}
