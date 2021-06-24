package AlgorithmsPrincetonCourse.Sorting.Exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;
import AlgorithmsPrincetonCourse.Sorting.HeapMaxPQ;
import AlgorithmsPrincetonCourse.Sorting.HeapMaxPQ;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;


/**
 */
public class TestHeapMaxPQ {
  @Test
  public void testConstructorSettingCapacity() {
    HeapMaxPQ<Integer> pq = new HeapMaxPQ<Integer>(5);
    assertEquals(0, pq.size());
    assertTrue(pq.isEmpty());
  }


  @Test
  public void testInsert() {
    HeapMaxPQ<Integer> pq = new HeapMaxPQ<Integer>(11);
    pq.insert(5);
    pq.insert(1);
    pq.insert(6);
    assertEquals(3, pq.size());
  }


  @Test
  public void testMax() {
    HeapMaxPQ<Integer> pq = new HeapMaxPQ<Integer>(20);
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
    HeapMaxPQ<Integer> pq = new HeapMaxPQ<Integer>(10);
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
    HeapMaxPQ<Integer> pq = new HeapMaxPQ<Integer>(10);
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

  // public static void main(String[] args) {
  //   int maxN = 1024;
  //   StdDraw.setPenColor(StdDraw.BLACK);
  //   StdDraw.setPenRadius(.01);
  //   StdDraw.setXscale(0, maxN);
  //   StdDraw.setYscale(0, 10*Math.log(maxN)/Math.log(2));
  //   // StdDraw.setYscale(0, 100*maxN);

  //   for (int n = 1; n < maxN; n+=2) {
  //     HeapMaxPQ<Integer> pq = new HeapMaxPQ<>(maxN);

  //     int arrAccessForInsertions = 0;
  //     for (int i = 0; i < n; i++) {
  //       pq.insert(StdRandom.uniform(100));
  //       arrAccessForInsertions += pq.getArrayAccessCount();
  //     }
      
  //     int arrAccessForDeletions = 0;
  //     for (int i = 0; i < n; i++) {
  //       pq.delMax();
  //       arrAccessForDeletions += pq.getArrayAccessCount();
  //     }
      
  //     int insertions = n;
  //     int deletions = n;
  //     double meanArrAccForInsertions = ((double) arrAccessForInsertions) / insertions;
  //     double meanArrAccForDeletions = ((double) arrAccessForDeletions) / deletions;
  //     System.out.println("-------------------------");
  //     System.out.println("     arr access for insertion: " + arrAccessForInsertions);
  //     System.out.println("mean arr access for insertion: " + meanArrAccForInsertions);
  //     System.out.println("      arr access for deletion: " + arrAccessForDeletions);
  //     System.out.println(" mean arr access for deletion: " + meanArrAccForDeletions);
      
  //     // StdDraw.setPenColor(StdDraw.GREEN);
  //     // StdDraw.point(insertions, arrAccessForInsertions);
      
  //     StdDraw.setPenColor(StdDraw.BLUE);
  //     StdDraw.point(insertions, meanArrAccForInsertions);
      
  //     // StdDraw.setPenColor(StdDraw.MAGENTA);
  //     // StdDraw.point(deletions, arrAccessForDeletions);
      
  //     StdDraw.setPenColor(StdDraw.RED);
  //     StdDraw.point(deletions, meanArrAccForDeletions);
  //   }

  //   StdDraw.show();
  //   System.out.println("finished");
  // }


  public static void main(String[] args) {
    int maxN = 2048, n=maxN;
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.setPenRadius(.01);
    StdDraw.setXscale(0, maxN);
    StdDraw.setYscale(0, 10*Math.log(maxN)/Math.log(2));
    // StdDraw.setYscale(0, 100*maxN);

    HeapMaxPQ<Integer> pq = new HeapMaxPQ<>(maxN);

    StdDraw.setPenColor(StdDraw.GREEN);
    for (int i = 1; i < n+1; i++) {
      pq.insert(StdRandom.uniform(100));
      StdDraw.point(i, Math.log(i)/Math.log(2));
      StdDraw.point(i, pq.getArrayAccessCount());
    }
    
    // StdDraw.setPenColor(StdDraw.MAGENTA);
    // for (int i = 1; i < n+1; i++) {
    //   pq.delMax();
    //   StdDraw.point(i, Math.log(i)/Math.log(2));
    //   StdDraw.point(i, pq.getArrayAccessCount());
    // }
    
    // int insertions = n;
    // int deletions = n;
    // double meanArrAccForInsertions = ((double) arrAccessForInsertions) / insertions;
    // double meanArrAccForDeletions = ((double) arrAccessForDeletions) / deletions;
    // System.out.println("-------------------------");
    // System.out.println("     arr access for insertion: " + arrAccessForInsertions);
    // System.out.println("mean arr access for insertion: " + meanArrAccForInsertions);
    // System.out.println("      arr access for deletion: " + arrAccessForDeletions);
    // System.out.println(" mean arr access for deletion: " + meanArrAccForDeletions);
    
    
    // StdDraw.setPenColor(StdDraw.BLUE);
    // StdDraw.point(insertions, meanArrAccForInsertions);
    
    
    // StdDraw.setPenColor(StdDraw.RED);
    // StdDraw.point(deletions, meanArrAccForDeletions);

    StdDraw.show();
    System.out.println("finished");
  }
}
