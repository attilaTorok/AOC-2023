import dev.attilatorok.Day4_1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day4Test {

    private final Day4_1 app1 = new Day4_1();

    @Test
    public void testPointsIn() {
        int actual = app1.pointsOnACard();
        int expected = 8;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTotalPoints() {
        int actual = app1.totalPoints();
        int expected = 13;

        Assertions.assertEquals(expected, actual);
    }

}
