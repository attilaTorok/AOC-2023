import dev.attilatorok.Day1_1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day1Test {

    private final Day1_1 app = new Day1_1();

    @Test
    public void testDay1_firstExample() {
        int answer = app.getAnswer("test/day1_first.txt");
        int expected = 142;

        Assertions.assertEquals(expected, answer);
    }

    @Test
    public void testDay1_firstInput() {
        int answer = app.getAnswer("input/day1_first.txt");
        int expected = 57346;

        Assertions.assertEquals(expected, answer);
    }

}
