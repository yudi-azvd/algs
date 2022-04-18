package algs.ch2.sorting.creativeproblems;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Teste para <code>creative-problem-2.2.14</code>
 */
public class TestSortedQueues {
  @Test
  public void testRange() {
    Queue<Integer> q1 = createSortedQueue(StdRandom.uniform(0, 1000));
    Queue<Integer> q2 = createSortedQueue(StdRandom.uniform(0, 1000));

    Queue<Integer> merged = SortedQueues.merge(q1, q2);

    assertTrue(SortedQueues.isSorted(merged));
  }

 
  /**
   * <p>Ainda não faz bem o que eu queria
   * não tá pegando os valores positivos
   * 
   * <p> Eu poderia simplesmente criar um vetor
   * de números aleatórios e depois ordená-lo.
   */
  public Queue<Integer> createSortedQueue(int size) {
    Queue<Integer> q = new Queue<>();

    int lo, hi;
    int intervalSize = (Integer.MAX_VALUE/2 - Integer.MIN_VALUE/2)/size;

    for (int i = 0; i < size; i++) {
      lo = Integer.MIN_VALUE + i*intervalSize;
      hi = lo + intervalSize - 1;
      q.enqueue(StdRandom.uniform(lo, hi));
    }

    return q;
  }

  @Test
  public void testCreateSortedQueue() {
    Queue<Integer> q = createSortedQueue(5);

    for (int i = 1; i < 1000; i++) {
      q = createSortedQueue(i);
      // System.out.println(q);
      assertTrue(SortedQueues.isSorted(q));
    }
  }

  @Test
  public void testIsSorted() {
    Queue<Integer> q = new Queue<>();

    for (int i = 0; i < 10; i += 2) {
      q.enqueue(i);
    }

    assertTrue(SortedQueues.isSorted(q));
    
    q.enqueue(-3);

    assertFalse(!SortedQueues.isSorted(q));
  }
}
