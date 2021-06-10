package AlgorithmsPrincetonCourse.AbstractData.Exercises;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;


/**
 * <code>exercise-1.2.6</code>
 */
public class AreCircularShifts {
  private static boolean areCircularShifts(String s1, String s2) {
    int shifts = s1.length();
    String shifted = s2;
    while (shifts-- > 0) {
      shifted = shifted.substring(1) + shifted.charAt(0);
      if (shifted.equals(s1))
        return true;
    }
    return false;
  }

  @Test
  public void testCircularShiftsDNA() {
    assertTrue(areCircularShifts("TGACGAC", "ACTGACG"));
  }

  @Test
  public void testCircularShiftsNumbers() {
    assertTrue(areCircularShifts("1234", "4123"));
  }

  @Test
  public void testCircularShiftsNumbers1() {
    assertTrue(areCircularShifts("1234", "3412"));
  }

  @Test
  public void testCircularShiftsNumbers2() {
    assertFalse(areCircularShifts("1234", "0981"));
  }
}
