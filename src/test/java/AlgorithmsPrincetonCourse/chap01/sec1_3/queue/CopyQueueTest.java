package AlgorithmsPrincetonCourse.chap01.sec1_3.queue;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

/**
 * Algorithms 4a ed.
 * creative-problems-1.3.41
 * 
 * Minha solução não segue a dica fornecida na questão.
 */
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
    LinkedListQueue<Integer> source = new LinkedListQueue<>();
    fillWithInts(source, 10);
    
    LinkedListQueue<Integer> copy = new LinkedListQueue<>(source);
    assertTrue(source != copy);

    assertTrue(copy.equals(source));

    assertTrue(copy.isCopyOf(source));
  }

  public void fillWithInts(LinkedListQueue<Integer> queue, int n) {
    for (int i = 0; i < n; i++) {
      queue.enqueue(i);
    }
  }
}