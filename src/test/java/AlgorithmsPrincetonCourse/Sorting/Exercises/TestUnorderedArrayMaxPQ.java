package AlgorithmsPrincetonCourse.Sorting.Exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;
import AlgorithmsPrincetonCourse.Sorting.IMaxPQ;
import AlgorithmsPrincetonCourse.Sorting.UnorderedArrayMaxPQ;

/**
 * <code>exercise-2.4.3</code> unordered array
 */
public class TestUnorderedArrayMaxPQ {
  @Test
  public void testConstructorWithArray() {
    Integer a[] = {3, 2, 5, 6, 1, 9};
    IMaxPQ<Integer> pq = new UnorderedArrayMaxPQ<Integer>(a);
    assertEquals(a.length, pq.size());
    assertFalse(pq.isEmpty());
  }

  @Test
  public void testConstructorSettingCapacity() {
    IMaxPQ<Integer> pq = new UnorderedArrayMaxPQ<Integer>(5);
    assertEquals(0, pq.size());
    assertTrue(pq.isEmpty());
  }

  @Test
  public void testDefaultConstructor() {
    IMaxPQ<Integer> pq = new UnorderedArrayMaxPQ<Integer>();
    assertEquals(0, pq.size());
    assertTrue(pq.isEmpty());
  }

  @Test
  public void testInsert() {
    IMaxPQ<Integer> pq = new UnorderedArrayMaxPQ<Integer>();
    pq.insert(5);
    pq.insert(1);
    pq.insert(6);
    assertEquals(3, pq.size());
  }

  @Test
  public void testMax() {
    IMaxPQ<Integer> pq = new UnorderedArrayMaxPQ<Integer>();
    pq.insert(5);
    pq.insert(1);
    pq.insert(6);
    assertEquals(6, pq.max());
    pq.insert(10);
    assertEquals(10, pq.max());
    pq.insert(-10);
    assertEquals(10, pq.max());
  }

  @Test
  public void testDelMax() {
    IMaxPQ<Integer> pq = new UnorderedArrayMaxPQ<Integer>();
    pq.insert(5);
    pq.insert(1);
    pq.insert(6);
    assertEquals(6, pq.delMax());
    assertEquals(5, pq.delMax());
    assertEquals(1, pq.delMax());
    assertTrue(pq.isEmpty());
  }

  @Test
  public void testDelMax2() {
    IMaxPQ<Integer> pq = new UnorderedArrayMaxPQ<Integer>();
    pq.insert(5);
    pq.insert(1);
    pq.insert(6);
    pq.insert(10);
    pq.insert(6);
    pq.insert(-10);
    pq.insert(100);
    pq.insert(200);
    
    assertEquals(200, pq.delMax());
    assertEquals(100, pq.delMax());
    assertEquals(10, pq.delMax());
    assertEquals(6, pq.delMax());
    assertEquals(4, pq.size());

    assertEquals(6, pq.delMax());
    assertEquals(5, pq.delMax());
    assertEquals(1, pq.delMax());
    assertEquals(-10, pq.delMax());
    assertTrue(pq.isEmpty());
    
    pq.insert(0);
    assertEquals(0, pq.delMax());
    assertTrue(pq.isEmpty());
  }
}
