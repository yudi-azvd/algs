package algs.ch2.sorting.creativeproblems;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.ValueSource;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

/**
 * <code>creative-problem-2.2.15</code>
 */
public class QueueMergeBU {
  public static Queue<Integer> sort(int[] arr) {
    Queue<Integer> aQueue;
    Queue<Queue<Integer>> theQueue = new Queue<>();

    for (int item : arr) {
      aQueue = new Queue<>();
      aQueue.enqueue(item);
      theQueue.enqueue(aQueue);
    }

    Queue<Integer> first, second, mergedQueue;
    while (theQueue.size() > 1) {
      first = theQueue.dequeue();
      second = theQueue.dequeue();

      mergedQueue = SortedQueues.merge(first, second);
      theQueue.enqueue(mergedQueue);
    }

    return theQueue.peek();
  }

  public int[] createRandomArray(int size) {
    int[] arr = new int[size];

    for (int i = 0; i < size; i++) {
      arr[i] = StdRandom.uniform(1000);
    }

    return arr;
  }

  // @ParameterizedTest não tá funcionando
  // @ParameterizedTest
  // @ValueSource(ints = {1, 3, 5, 10, 99, 1000, 9999})
  @Test
  public void testSort() {
    int[] arr = createRandomArray(StdRandom.uniform(1, 9999));

    Queue<Integer> sorted = sort(arr);

    assertTrue(SortedQueues.isSorted(sorted));
  }
}
