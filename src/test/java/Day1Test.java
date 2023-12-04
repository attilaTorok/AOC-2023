import dev.attilatorok.Day1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day1Test {

    private final Day1 app = new Day1();

    @Test
    public void testDay1Example() {
        int answer = app.getAnswer("test/day1_first.txt");
        int expected = 142;

        Assertions.assertEquals(expected, answer);
    }

}
