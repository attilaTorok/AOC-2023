package dev.attilatorok;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day4_2 extends Day4_1 {

    public double totalPoints(BufferedReader reader) throws IOException {
        Map<Integer, Double> cardsWithCopies = new HashMap<>();
        String line;
        double sum = 0;

        while ((line = reader.readLine()) != null) {
            Card card = createCardFromLine(line);
            updateCardValue(cardsWithCopies, card.number(), 1);

            long points = pointsOnACard(card.winningNumbers(), card.otherNumbers());
            Double updateAmount = cardsWithCopies.get(card.number());
            for (int i = 1; i <= points; i++) {
                updateCardValue(cardsWithCopies, card.number() + i, updateAmount);
            }

            sum += updateAmount;
        }

        return sum;
    }

    private void updateCardValue(Map<Integer, Double> cardsWithCopies, int cardNumber, double updateAmount) {
        if (cardsWithCopies.containsKey(cardNumber)) {
            cardsWithCopies.compute(cardNumber, (k, v) -> v + updateAmount);
        } else {
            cardsWithCopies.put(cardNumber, 1d);
        }
    }

    @Override
    public long pointsOnACard(List<Integer> winningNumbers, List<Integer> otherNumbers) {
        return winningNumbers.stream().filter(otherNumbers::contains).count();
    }

}
