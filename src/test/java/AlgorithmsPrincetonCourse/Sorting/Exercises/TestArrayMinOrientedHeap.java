package AlgorithmsPrincetonCourse.Sorting.Exercises;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;

/**
 * <code>exercise-2.4.15</code>
 */
public class TestArrayMinOrientedHeap {
  @Test
  public void test1() {
    Integer[] a = {0, 0, 4, 6, 6, 7, 11, 12};
    assertTrue(ArrayMinOrientedHeap.check(a));
  }


  // array taken from: https://github.com/reneargento/algorithms-sedgewick-wayne/blob/master/src/chapter2/section4/Exercise15.java
  @Test
  public void test2() {
    Integer[] a = {0, 0, 1, 2, -1, -5, 99, 6, 7, 8};
    assertFalse(ArrayMinOrientedHeap.check(a));
  }
}
