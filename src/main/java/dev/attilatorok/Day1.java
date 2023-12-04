package dev.attilatorok;

import java.io.BufferedReader;
import java.io.IOException;

//https://adventofcode.com/2023/day/1
public class Day1 {

    public static void main(final String[] args) {
    }

    public int getAnswer(String fileName) {
        int sum = 0;

        try (BufferedReader reader = Utils.getBufferedReader(fileName)) {
            String line;
            while ((line = reader.readLine()) != null) {
                sum += findNumber(line) * 10;
                sum += findNumber(new StringBuilder(line).reverse().toString());
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return sum;
    }

    public int findNumber(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                return Character.getNumericValue(string.charAt(i));
            }
        }

        return 0;
    }

}
