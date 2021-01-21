package AlgorithmsPrincetonCourse.Deque;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import AlgorithmsPrincetonCourse.Assignments.queues.IDeque;
import AlgorithmsPrincetonCourse.Assignments.queues.LinkedListDeque;

public class DequeTest {
  /**
   * LEMBRAR DE REFATORAR TESTES PARA
   * USAR APENAS UM TESTE PARA VÁRIAS 
   * IMPLEMENTAÇÕES DE IDEQUE
   */

  @Test
  public void theLastFirstlyAddedShouldAlwaysBeFirst() {
    IDeque<Integer> deque = new LinkedListDeque<>();
    deque.addFirst(0);
    deque.addFirst(1);
    
    int first = deque.removeFirst();
    
    assertEquals(1, first);
    
    deque = new LinkedListDeque<>();
    deque.addFirst(0);
    deque.addFirst(1);
    deque.addFirst(2);
    deque.addFirst(3);
    deque.addFirst(4);
    
    int size;
    for (int i = 4; i >= 0; --i) {
      first = deque.removeFirst();
      size = deque.size();
      assertEquals(i, first);
      assertEquals(i, size);
    }
  }

  @Test
  // theLastlyLastAddedShoulAlwaysBeLast ???
  public void theLastLastlyAddedShoulAlwaysBeLast() {
    IDeque<Integer> deque = new LinkedListDeque<>();
    deque.addLast(0);
    deque.addLast(1);
    
    int last = deque.removeLast();
    
    assertEquals(1, last);
    
    deque = new LinkedListDeque<>();

    int finalSize = 5;

    for (int i = 0; i < finalSize; i++) {
      deque.addLast(i);
    }

    // the last is finalSize - 1
    int size;
    for (int i = finalSize; i > 0; --i) {
      last = deque.removeLast();
      size = deque.size();
      assertEquals(i-1, last);
      assertEquals(i-1, size);
    }
  }

  @Test
  public void testAddFirstAndRemoveLast() {
    int numberOfItems = 10;
    IDeque<Integer> deque = new LinkedListDeque<>();

    for (int i = 1; i <= numberOfItems; i++) {
      deque.addFirst(i);
    }

    for (int i = 1; i <= numberOfItems; i++) {
      int last = deque.removeLast();
      assertEquals(i, last);
    }
  }

  @Test
  public void fillUpAndEmpty() {
    int numberOfItems = 10;
    IDeque<Integer> deque = new LinkedListDeque<>();

    for (int i = 1; i <= numberOfItems; i++) {
      deque.addFirst(i);
    }

    for (int i = 1; i <= numberOfItems; i++) {
      deque.removeLast();
    }

    assertEquals(1, 1);

    for (int i = 1; i <= numberOfItems; i++) {
      deque.addFirst(i);
    }
  }

  @Test
  public void testDequeIterator() {
    LinkedListDeque<Integer> deque = new LinkedListDeque<>();

    int i, size = 10;
    for (i = 0; i < size; i++) {
      deque.addFirst(i);
    }

    for (int item : deque) {
      assertEquals(item, --i);
    }
  }

  @Test
  public void test5() {
    LinkedListDeque<Integer> deque = new LinkedListDeque<>();
    
    deque.addLast(1);
    deque.isEmpty();
    deque.addLast(3);
    deque.addLast(4);
    deque.addLast(5);
    deque.addLast(6);
    deque.addLast(7);
    deque.removeFirst();
    deque.addLast(9);
  }

  @Test
  public void test9() {
    LinkedListDeque<Integer> deque = new LinkedListDeque<>();

    int n = 10;

    for (int i = 0; i < n; ++i) {
      deque.addFirst(i);
    }

    Iterator<Integer> it = deque.iterator();

    System.out.println(it.hasNext());
  }
}