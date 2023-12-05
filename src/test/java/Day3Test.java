import dev.attilatorok.Day3_1;
import dev.attilatorok.Day3_2;
import dev.attilatorok.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

public class Day3Test {

    private final Day3_1 app1 = new Day3_1();
    private final Day3_2 app2 = new Day3_2();

    @Test
    public void testPartSum() throws IOException {
        try (BufferedReader reader = Utils.getBufferedReader("test/day3_first.txt")) {
            int actual = app1.getPartSum(reader);
            int expected = 4361;

            Assertions.assertEquals(expected, actual);
        }
    }

    @Test
    public void testPartSum1() throws IOException {
        try (BufferedReader reader = Utils.getBufferedReader("test/day3_first_1.txt")) {
            int actual = app1.getPartSum(reader);
            int expected = 502;

            Assertions.assertEquals(expected, actual);
        }
    }

    @Test
    public void inputPart1() throws IOException {
        try (BufferedReader reader = Utils.getBufferedReader("input/day3_part1.txt")) {
            int actual = app1.getPartSum(reader);
            int expected = 533784;

            Assertions.assertEquals(expected, actual);
        }
    }

    @Test
    public void testGearRation() throws IOException {
        try (BufferedReader reader = Utils.getBufferedReader("test/day3_first.txt")) {
            int actual = app2.getGearRatio(reader);
            int expected = 16345;

            Assertions.assertEquals(expected, actual);
        }
    }

    @Test
    public void testGearRation1() throws IOException {
        try (BufferedReader reader = Utils.getBufferedReader("test/day3_first_1.txt")) {
            int actual = app2.getGearRatio(reader);
            int expected = 467835;

            Assertions.assertEquals(expected, actual);
        }
    }

}
