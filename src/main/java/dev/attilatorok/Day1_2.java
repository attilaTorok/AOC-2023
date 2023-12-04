package dev.attilatorok;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Day1_2 extends Day1_1 {

    private static final Map<String, Integer> NUMBERS = new HashMap<>();

    static {
        NUMBERS.put("one", 1);
        NUMBERS.put("two", 2);
        NUMBERS.put("three", 3);
        NUMBERS.put("four", 4);
        NUMBERS.put("five", 5);
        NUMBERS.put("six", 6);
        NUMBERS.put("seven", 7);
        NUMBERS.put("eight", 8);
        NUMBERS.put("nine", 9);
    }

    @Override
    public int getAnswer(String fileName) {
        int sum = 0;

        try (BufferedReader reader = Utils.getBufferedReader(fileName)) {
            String line;
            while ((line = reader.readLine()) != null) {
                int firstIndex = getFirstNumberIndex(line);
                int lastIndex = getLastNumberIndex(line);
                String numberAsString = "";
                List<String> containedNumbers = new LinkedList<>();

                sum += getFirstValue(line, firstIndex, numberAsString, containedNumbers) * 10;
                numberAsString = "";
                sum += getSecondValue(line, lastIndex, numberAsString, containedNumbers);
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return sum;
    }

    private int getLastNumberIndex(String line) {
        String reversedLine = new StringBuilder(line).reverse().toString();
        return findNumberIndex(reversedLine) == -1 ? -1 : line.length() - 1 - findNumberIndex(reversedLine);
    }

    private int getFirstNumberIndex(String line) {
        return findNumberIndex(line) > -1 ? findNumberIndex(line) : line.length();
    }

    private static int getFirstValue(String line, int firstIndex, String numberAsString, List<String> containedNumbers) {
        for (String number : NUMBERS.keySet()) {
            if (line.contains(number)) {
                containedNumbers.add(number);
                if (firstIndex > 1 && line.indexOf(number) < firstIndex) {
                    firstIndex = line.indexOf(number);
                    numberAsString = number;
                }
            }
        }

        return !numberAsString.equals("") ? NUMBERS.get(numberAsString) : Character.getNumericValue(line.charAt(firstIndex));
    }

    private static int getSecondValue(String line, int lastIndex, String numberAsString, List<String> containedNumbers) {
        for (String number : containedNumbers) {
            if (lastIndex < line.length() - 2 && line.lastIndexOf(number) > lastIndex) {
                lastIndex = line.lastIndexOf(number);
                numberAsString = number;
            }
        }

        return !numberAsString.equals("") ? NUMBERS.get(numberAsString) : Character.getNumericValue(line.charAt(lastIndex));
    }

}
