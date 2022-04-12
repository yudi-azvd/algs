package algs.chap02.sorting.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;
import algs.chap02.sorting.IMaxPQ;
import algs.chap02.sorting.UnorderedArrayMaxPQ;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;


/**
 * <code>exercise-2.4.3</code> unordered array
 */
public class TestUnorderedArrayMaxPQ {
  public static IMaxPQ<Integer> pq;

  // @BeforeAll
  // public static void setup() {
  //   IMaxPQ<Integer> pq = new UnorderedArrayMaxPQ<Integer>();
  // }

  @Test
  public void testSizeAsSoonAsConstructed() {
    IMaxPQ<Integer> pq = new UnorderedArrayMaxPQ<>();
    assertEquals(0, pq.size());
    assertTrue(pq.isEmpty());
  }

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

  public static void main(String[] args) {
    int maxN = 1024;
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.setPenRadius(.01);
    StdDraw.setXscale(0, maxN);
    StdDraw.setYscale(0, maxN);

    for (int n = 1; n < maxN; n++) {
      UnorderedArrayMaxPQ<Integer> pq = new UnorderedArrayMaxPQ<>();

      for (int i = 0; i < n; i++) {
        pq.insert(StdRandom.uniform(100));
      }

      int arrAccess = pq.getArrayAccessCount();
      int insertions = pq.getInsertionCount();
      double amortized = ((double) arrAccess) / insertions;
      System.out.println("-------------------------");
      System.out.println("    arr acc count: " + arrAccess);
      System.out.println("     insert count: " + insertions);
      System.out.println("amortized arr acc: " + ((double) arrAccess) / insertions);
      
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.point(n, arrAccess);
      
      StdDraw.setPenColor(StdDraw.RED);
      StdDraw.point(n, amortized);
    }

    StdDraw.show();
  }
}
