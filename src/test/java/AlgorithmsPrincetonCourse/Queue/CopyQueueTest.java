package AlgorithmsPrincetonCourse.Queue;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.Test;

public class CopyQueueTest {
  @Test
  public void copyIsEqualToSource() {
    LinkedListQueue<Integer> source = new LinkedListQueue<>();
    fillWithInts(source, 10);

    LinkedListQueue<Integer> copy = new LinkedListQueue<>(source);

    assertTrue(source != copy);
    
    assertTrue(copy.equals(source));
  }
  
  @Test
  public void testIndepence() {
    LinkedListQueue<String> source = new LinkedListQueue<>();
    fillWithStrings(source, 10);
    
    LinkedListQueue<String> copy = new LinkedListQueue<>(source);
    assertTrue(source != copy);

    assertTrue(copy.equals(source));
    
    copy.dequeue();
    assertTrue(!copy.peek().equals(source.peek()));

    source.dequeue();
    assertTrue(copy.peek().equals(source.peek()));

    source.dequeue();
    assertTrue(!copy.peek().equals(source.peek()));

    source.dequeue();
    assertTrue(!copy.peek().equals(source.peek()));
  }

  public void fillWithInts(LinkedListQueue<Integer> queue, int n) {
    for (int i = 0; i < n; i++) {
      queue.enqueue(i);
    }
  }

  public void fillWithStrings(LinkedListQueue<String> queue, int n) {
    for (int i = 0; i < n; i++) {
      queue.enqueue(Integer.toString(i));
    }
  }
}