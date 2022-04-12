package algs.chap02.sorting.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;
import algs.chap02.sorting.IMaxPQ;
import algs.chap02.sorting.OrderedArrayMaxPQ;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;


/**
 * <code>exercise-2.4.3</code> unordered array
 */
public class TestOrderedArrayMaxPQ {
  public static IMaxPQ<Integer> pq;

  @Test
  public void testWithSimpleArray() {
    Integer a[] = {1, 3, 5, 7, 9, 11};
    IMaxPQ<Integer> pq = new OrderedArrayMaxPQ<Integer>(a);
    assertEquals(a.length, pq.size());
    assertFalse(pq.isEmpty());
  }


  @Test
  public void testConstructorWithArray() {
    Integer a[] = {3, 2, 5, 6, 1, 9};
    IMaxPQ<Integer> pq = new OrderedArrayMaxPQ<Integer>(a);
    assertEquals(a.length, pq.size());
    assertFalse(pq.isEmpty());
  }

  @Test
  public void testConstructorSettingCapacity() {
    IMaxPQ<Integer> pq = new OrderedArrayMaxPQ<Integer>(5);
    assertEquals(0, pq.size());
    assertTrue(pq.isEmpty());
  }

  @Test
  public void testDefaultConstructor() {
    IMaxPQ<Integer> pq = new OrderedArrayMaxPQ<Integer>();
    assertEquals(0, pq.size());
    assertTrue(pq.isEmpty());
  }

  @Test
  public void testInsert() {
    IMaxPQ<Integer> pq = new OrderedArrayMaxPQ<Integer>();
    pq.insert(5);
    pq.insert(1);
    pq.insert(6);
    assertEquals(3, pq.size());
  }

  @Test
  public void testInsertWithGivenArray() {
    Integer a[] = {1, 3, 5, 7, 9, 11};
    IMaxPQ<Integer> pq = new OrderedArrayMaxPQ<Integer>(a);
    pq.insert(6);
    assertEquals(a.length+1, pq.size());
  }

  @Test
  public void testMax() {
    IMaxPQ<Integer> pq = new OrderedArrayMaxPQ<Integer>();
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
    IMaxPQ<Integer> pq = new OrderedArrayMaxPQ<Integer>();
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
    IMaxPQ<Integer> pq = new OrderedArrayMaxPQ<Integer>();
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

  public static void main(String[] args) {
    int maxN = 1024;
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.setPenRadius(.01);
    StdDraw.setXscale(0, maxN);
    StdDraw.setYscale(0, maxN);

    for (int n = 1; n < maxN; n++) {
      OrderedArrayMaxPQ<Integer> pq = new OrderedArrayMaxPQ<>();

      for (int i = 0; i < n; i++) {
        pq.insert(StdRandom.uniform(100));
      }

      int arrAccess = 0;
      for (int i = 0; i < n; i++) {
        pq.delMax();
      }
      
      arrAccess += pq.getArrayAccessCount();
      int insertions = pq.getInsertionCount(); // del Max count. olhar OrderedArrayMaxPQ
      double amortized = ((double) arrAccess) / insertions;
      System.out.println("-------------------------");
      System.out.println("    arr acc count: " + arrAccess);
      System.out.println("    del max count: " + insertions);
      System.out.println("amortized arr acc: " + ((double) arrAccess) / insertions);
      
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.point(n, arrAccess);
      
      StdDraw.setPenColor(StdDraw.RED);
      StdDraw.point(n, amortized);
    }

    StdDraw.show();
  }
}
