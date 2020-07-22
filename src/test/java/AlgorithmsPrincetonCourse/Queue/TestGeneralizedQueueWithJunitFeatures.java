package AlgorithmsPrincetonCourse.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestGeneralizedQueueWithJunitFeatures {
  private IGeneralizedQueue<Integer> queue;

  // https://stackoverflow.com/questions/29950953/getrequests-must-return-an-iterable-of-arrays
  @Parameters(name="{index}: {0}")
  public static Collection<Object[]> data() {
    Collection<Object[]> params = new ArrayList<>(2);

    params.add(
      new Object[] { new LinkedListGeneralizedQueue<>() }
    );

    // params.add(
    //   new Object[] { new ResizingArrayGeneralizedQueue<>() }
    // );

    return params;
  }

  public TestGeneralizedQueueWithJunitFeatures(IGeneralizedQueue<Integer> queue) {
    this.queue = queue;
  }

  @Test
  public void test() {
    for (int i = 0; i < 10; i++) {
      queue.insert(i);
    }

    assertEquals(9, queue.delete(9));
    assertEquals(8, queue.delete(8));
    assertEquals(7, queue.delete(7));
    assertEquals(6, queue.delete(6));
    assertEquals(5, queue.delete(5));
    assertEquals(4, queue.delete(4));
    assertEquals(3, queue.delete(3));
    assertEquals(2, queue.delete(2));
    assertEquals(1, queue.delete(1));
    assertEquals(0, queue.delete(0));

    for (int i = 0; i < 10; i++) {
      queue.insert(i);
    }

    assertEquals(9, queue.delete(9));
    assertEquals(8, queue.delete(8));
    assertEquals(7, queue.delete(7));
    assertEquals(6, queue.delete(6));
    assertEquals(5, queue.delete(5));
    assertEquals(4, queue.delete(4));
    assertEquals(3, queue.delete(3));
    assertEquals(2, queue.delete(2));
    assertEquals(1, queue.delete(1));
    assertEquals(0, queue.delete(0));
  }
}

// Não funcionou :/
// https://junit.org/junit4/javadoc/4.12/org/junit/runners/Parameterized.html
// public static Iterable<Object> data() {
//   // public static Collection<Object[]> data() {
//     return Arrays.asList(new Object[] {
//       new LinkedListGeneralizedQueue<>(),
//       new ResizingArrayGeneralizedQueue<>(),
//     });
// }