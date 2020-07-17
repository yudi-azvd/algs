package AlgorithmsPrincetonCourse.RandomizedQueue;

import org.junit.Test;

import AlgorithmsPrincetonCourse.Assignments.queues.RandomizedQueue;

public class RandomizedQueueTest {
  @Test
  public void test7() {
    int n = 10;
    RandomizedQueue<Integer> queue = new RandomizedQueue<>();

    for (int i = 0; i < n; i++) {
      queue.enqueue(i);
    }
  }
}