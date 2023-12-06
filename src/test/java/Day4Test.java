import dev.attilatorok.Day4_1;
import dev.attilatorok.Day4_2;
import dev.attilatorok.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Day4Test {

    private final Day4_1 app1 = new Day4_1();
    private final Day4_2 app2 = new Day4_2();

    @Test
    public void testPointsIn() {
        int actual = app1.pointsOnACard(List.of(41, 48, 83, 86, 17), List.of(83, 86,  6, 31, 17,  9, 48, 53));
        int expected = 8;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTotalPoints() throws IOException {
        try (BufferedReader reader = Utils.getBufferedReader("test/day4_first.txt")) {
            int actual = app1.totalPoints(reader);
            int expected = 13;

            Assertions.assertEquals(expected, actual);
        }
    }

    @Test
    public void inputTotalPoints() throws IOException {
        try (BufferedReader reader = Utils.getBufferedReader("input/day4_part1.txt")) {
            int actual = app1.totalPoints(reader);
            int expected = 19855;

            Assertions.assertEquals(expected, actual);
        }
    }

    @Test
    public void testTotalPointsWithCopies() throws IOException {
        try (BufferedReader reader = Utils.getBufferedReader("input/day4_part1.txt")) {
            int actual = app2.testTotalPointsWithCopies(reader);
            int expected = 19855;

            Assertions.assertEquals(expected, actual);
        }
    }

}
