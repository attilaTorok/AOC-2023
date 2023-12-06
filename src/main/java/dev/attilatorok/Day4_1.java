package dev.attilatorok;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4_1 {

    public int totalPoints(BufferedReader reader) throws IOException {
        int totalPoints = 0;
        String line;

        while ((line = reader.readLine()) != null) {
            Card card = createCardFromLine(line);
            totalPoints += pointsOnACard(card.winningNumbers, card.otherNumbers);
        }

        return totalPoints;
    }

    public int pointsOnACard(List<Integer> winningNumbers, List<Integer> otherNumbers) {
        int sum = 0;

        for (Integer winning : winningNumbers) {
            if (otherNumbers.contains(winning)) {
                if (sum == 0) {
                    sum++;
                } else {
                    sum *= 2;
                }
            }
        }

        return sum;
    }

    public Card createCardFromLine(String line) {
        String[] lineSplit = line.split(":");
        String[] firstPartSplit = lineSplit[0].split(" ");
        int number = Integer.parseInt(firstPartSplit[firstPartSplit.length-1]);

        String[] numbers = lineSplit[1].split("\\|");
        List<Integer> winningNumbers = Arrays.stream(numbers[0].split(" ")).filter(s -> !"".equals(s)).map(Integer::valueOf).toList();
        List<Integer> otherNumbers = Arrays.stream(numbers[1].split(" ")).filter(s -> !"".equals(s)).map(Integer::valueOf).toList();

        return new Card(number, winningNumbers, otherNumbers);
    }


    public record Card (int number, List<Integer> winningNumbers, List<Integer> otherNumbers) {}
}
