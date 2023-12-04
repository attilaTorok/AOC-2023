import dev.attilatorok.Day1_1;
import dev.attilatorok.Day1_2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day1Test {

    private final Day1_1 app1 = new Day1_1();
    private final Day1_2 app2 = new Day1_2();


    @Test
    public void testDay1_firstExample() {
        int answer = app1.getAnswer("test/day1_first.txt");
        int expected = 142;

        Assertions.assertEquals(expected, answer);
    }

    @Test
    public void testDay1_firstInput() {
        int answer = app1.getAnswer("input/day1_first.txt");
        int expected = 57346;

        Assertions.assertEquals(expected, answer);
    }

    @Test
    public void testDay1_secondExample() {
        int answer = app2.getAnswer("test/day1_second.txt");
        int expected = 281;

        Assertions.assertEquals(expected, answer);
    }

    @Test
    public void testDay1_secondExample2() {
        int answer = app2.getAnswer("test/day1_second_2.txt");
        int expected = 625;

        Assertions.assertEquals(expected, answer);
    }

    @Test
    public void testDay1_secondExample3() {
        int answer = app2.getAnswer("test/day1_second_3.txt");
        int expected = 66;

        Assertions.assertEquals(expected, answer);
    }

    @Test
    public void testDay1_secondExample4() {
        int answer = app2.getAnswer("test/day1_second_4.txt");
        int expected = 39;

        Assertions.assertEquals(expected, answer);
    }

    @Test
    public void testDay1_secondExample5() {
        int answer = app2.getAnswer("test/day1_second_5.txt");
        int expected = 11;

        Assertions.assertEquals(expected, answer);
    }

    @Test
    public void testDay1_secondExample6() {
        int answer = app2.getAnswer("test/day1_second_6.txt");
        int expected = 18;

        Assertions.assertEquals(expected, answer);
    }

    @Test
    public void testDay1_secondInput() {
        int answer = app2.getAnswer("input/day1_second.txt");
        int expected = 57345;

        Assertions.assertEquals(expected, answer);
    }

}
