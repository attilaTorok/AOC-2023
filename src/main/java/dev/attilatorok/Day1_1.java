package dev.attilatorok;

import java.io.BufferedReader;
import java.io.IOException;

//https://adventofcode.com/2023/day/1
public class Day1_1 {

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

    private int findNumber(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                return Character.getNumericValue(string.charAt(i));
            }
        }

        return 0;
    }

}
