import dev.attilatorok.Day2_1;
import dev.attilatorok.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

public class Day2Test {

    private final Day2_1 app1 = new Day2_1();

    private String getLineWithoutGame(String line) {
        return line.split(":")[1];
    }

    @Test
    public void testGameIsPossible() throws IOException {
        try (BufferedReader reader = Utils.getBufferedReader("test/day2_first.txt")) {
            boolean actual = app1.isGamePossible(getLineWithoutGame(reader.readLine()));

            Assertions.assertTrue(actual);
        }
    }

    @Test
    public void testGameIsImpossible() throws IOException {
        try (BufferedReader reader = Utils.getBufferedReader("test/day2_first_2.txt")) {
            boolean actual = app1.isGamePossible(getLineWithoutGame(reader.readLine()));

            Assertions.assertFalse(actual);
        }
    }

    @Test
    public void getAnswerTest() throws IOException {
        try (BufferedReader reader = Utils.getBufferedReader("test/day2_first_3.txt")) {
            int expected = 8;
                int actual = app1.getAnswer(reader);

            Assertions.assertEquals(expected, actual);
        }
    }

    @Test
    public void getAnswer() throws IOException {
        try (BufferedReader reader = Utils.getBufferedReader("input/day2_first.txt")) {
            int expected = 2541;
            int actual = app1.getAnswer(reader);

            Assertions.assertEquals(expected, actual);
        }
    }

}
