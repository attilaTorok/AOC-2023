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
                sum += Character.getNumericValue(line.charAt(findNumberIndex(line))) * 10;
                String reversedLine = new StringBuilder(line).reverse().toString();
                sum += Character.getNumericValue(reversedLine.charAt(findNumberIndex(reversedLine)));
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return sum;
    }

    protected int findNumberIndex(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                return i;
            }
        }

        return -1;
    }

}
