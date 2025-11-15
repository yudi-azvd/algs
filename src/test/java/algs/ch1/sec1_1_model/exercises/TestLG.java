package algs.ch1.sec1_1_model.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * <code>exercise-1.1.14</code>
 */
public class TestLG {
    public static int lg(int n) {
        return 0;
    }

    @ParameterizedTest
    @CsvSource({ "2,7", "3,8", "3,10" })
    public void test(int expected, int n) {
        assertEquals(2, lg(7));
        assertEquals(3, lg(8));
        assertEquals(3, lg(10));
    }
}
