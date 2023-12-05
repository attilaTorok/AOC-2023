package dev.attilatorok;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//https://adventofcode.com/2023/day/3
public class Day3_1 {

    public int getPartSum(BufferedReader reader) throws IOException {
        int sum = 0;
        Line[] lines = new Line[3];

        lines[0] = readLine(reader.readLine());
        lines[1] = readLine(reader.readLine());
        sum += sumOfPartsInFirstLine(lines);

        String str;
        while ((str = reader.readLine()) != null) {
            lines[2] = readLine(str);

            sum += sumOfPartInLine(lines);
            shiftLines(lines);
        }

        sum += sumOfPartsInLastLine(lines);

        return sum;
    }

    protected Line readLine(String str) {
        Line line = new Line();
        boolean isLastCharDigit = false;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (Character.isDigit(currentChar)) {
                if (isLastCharDigit) {
                    Number number = line.getLastNumber();
                    number.setValue(number.getValue() * 10 + Character.getNumericValue(currentChar));
                    number.setEndIndex(i);
                } else {
                    isLastCharDigit = true;
                    Number number = new Number(Character.getNumericValue(currentChar), i);
                    line.addNumber(number);
                }

            } else if (currentChar != '.') {
                line.addSymbol(i);
                isLastCharDigit = false;
            } else {
                isLastCharDigit = false;
            }
        }

        return line;
    }

    protected int sumOfPartsInFirstLine(Line[] lines) {
        int sum = 0;
        boolean isFound = false;

        for (Number number : lines[0].getNumbers()) {
            for (int symbolIndex : lines[0].getSymbols()) {
                if (number.isCloseToSymbol(symbolIndex)) {
                    sum += number.getValue();
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                for (int symbolIndex : lines[1].getSymbols()) {
                    if (number.isCloseToSymbol(symbolIndex)) {
                        sum += number.getValue();
                        break;
                    }
                }
            }
            isFound = false;
        }

        return sum;
    }

    protected int sumOfPartInLine(Line[] lines) {
        int sum = 0;
        boolean isFound = false;

        for (Number number : lines[1].getNumbers()) {
            for (int symbolIndex : lines[0].getSymbols()) {
                if (number.isCloseToSymbol(symbolIndex)) {
                    sum += number.getValue();
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                for (int symbolIndex : lines[1].getSymbols()) {
                    if (number.isCloseToSymbol(symbolIndex)) {
                        sum += number.getValue();
                        isFound = true;
                        break;
                    }
                }
            }

            if (!isFound) {
                for (int symbolIndex : lines[2].getSymbols()) {
                    if (number.isCloseToSymbol(symbolIndex)) {
                        sum += number.getValue();
                        break;
                    }
                }
            }

            isFound = false;
        }

        return sum;
    }

    protected int sumOfPartsInLastLine(Line[] lines) {
        int sum = 0;
        boolean isFound = false;

        for (Number number : lines[1].getNumbers()) {
            for (int symbolIndex : lines[1].getSymbols()) {
                if (number.isCloseToSymbol(symbolIndex)) {
                    sum += number.getValue();
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                for (int symbolIndex : lines[0].getSymbols()) {
                    if (number.isCloseToSymbol(symbolIndex)) {
                        sum += number.getValue();
                        break;
                    }
                }
            }

            isFound = false;
        }

        return sum;
    }

    protected void shiftLines(Line[] lines) {
        lines[0] = lines[1];
        lines[1] = lines[2];
        lines[2] = null;
    }

    static class Line {
        private final List<Number> numbers = new ArrayList<>();
        private final List<Integer> symbols = new ArrayList<>();

        public List<Number> getNumbers() {
            return numbers;
        }

        public List<Integer> getSymbols() {
            return symbols;
        }

        public void addSymbol(int index) {
            symbols.add(index);
        }

        public void addNumber(Number number) {
            numbers.add(number);
        }

        public Number getLastNumber() {
            return numbers.get(numbers.size() - 1);
        }

    }

    static class Number {
        private int value;
        private final int startIndex;
        private int endIndex;

        public Number(int value, int index) {
            this.value = value;
            this.startIndex = index;
            this.endIndex = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }

        public boolean isCloseToSymbol(int symbolIndex) {
            return symbolIndex >= startIndex - 1 && symbolIndex <= endIndex + 1;
        }

    }

}
