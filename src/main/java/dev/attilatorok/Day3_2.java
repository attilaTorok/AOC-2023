package dev.attilatorok;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3_2 extends Day3_1 {

    public int getGearRatio(BufferedReader reader) throws IOException {
        int ratio = 0;
        Line[] lines = new Line[3];

        lines[0] = readLine(reader.readLine());
        lines[1] = readLine(reader.readLine());
        ratio += sumOfPartsInFirstLine(lines);

        String str;
        while ((str = reader.readLine()) != null) {
            lines[2] = readLine(str);

            ratio += sumOfPartInLine(lines);
            shiftLines(lines);
        }

        ratio += sumOfPartsInLastLine(lines);

        return ratio;
    }

    @Override
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

            } else if (currentChar =='*') {
                line.getSymbols().add(i);
                isLastCharDigit = false;
            } else {
                isLastCharDigit = false;
            }
        }

        return line;
    }

    @Override
    protected int sumOfPartsInFirstLine(Line[] lines) {
        int sum = 0;

        for (int symbolIndex : lines[0].getSymbols()) {
            List<Number> closeNumbers = new ArrayList<>();
            findCloseNumbers(lines[0].getNumbers(), symbolIndex, closeNumbers);
            findCloseNumbers(lines[1].getNumbers(), symbolIndex, closeNumbers);

            if (closeNumbers.size() == 2) {
                sum += closeNumbers.get(0).getValue() * closeNumbers.get(1).getValue();
            }
        }

        return sum;
    }

    @Override
    protected int sumOfPartInLine(Line[] lines) {
        int sum = 0;

        for (int symbolIndex : lines[1].getSymbols()) {
            List<Number> closeNumbers = new ArrayList<>();
            findCloseNumbers(lines[0].getNumbers(), symbolIndex, closeNumbers);
            findCloseNumbers(lines[1].getNumbers(), symbolIndex, closeNumbers);
            findCloseNumbers(lines[2].getNumbers(), symbolIndex, closeNumbers);

            if (closeNumbers.size() == 2) {
                sum += closeNumbers.get(0).getValue() * closeNumbers.get(1).getValue();
            }
        }

        return sum;
    }

    @Override
    protected int sumOfPartsInLastLine(Line[] lines) {
        int sum = 0;

        for (int symbolIndex : lines[1].getSymbols()) {
            List<Number> closeNumbers = new ArrayList<>();
            findCloseNumbers(lines[0].getNumbers(), symbolIndex, closeNumbers);
            findCloseNumbers(lines[1].getNumbers(), symbolIndex, closeNumbers);

            if (closeNumbers.size() == 2) {
                sum += closeNumbers.get(0).getValue() * closeNumbers.get(1).getValue();
            }
        }

        return sum;
    }

    private void findCloseNumbers(List<Number> numbers, int symbolIndex, List<Number> closeNumbers) {
        for (Number number : numbers) {
            if (number.isCloseToSymbol(symbolIndex)) {
                closeNumbers.add(number);
            }
        }
    }
}
