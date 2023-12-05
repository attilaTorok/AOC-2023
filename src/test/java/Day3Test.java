import dev.attilatorok.Day3_1;
import dev.attilatorok.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

public class Day3Test {

    private final Day3_1 app1 = new Day3_1();

    @Test
    public void testPartSum() throws IOException {
        try (BufferedReader reader = Utils.getBufferedReader("test/day3_first.txt")) {
            int actual = app1.getPartSum();
            int expected = 4361;

            Assertions.assertEquals(expected, actual);
        }
    }

    @Test
    public void testPartSum1() throws IOException {
        try (BufferedReader reader = Utils.getBufferedReader("test/day3_first_1.txt")) {
            int actual = app1.getPartSum();
            int expected = 467;

            Assertions.assertEquals(expected, actual);
        }
    }

}
