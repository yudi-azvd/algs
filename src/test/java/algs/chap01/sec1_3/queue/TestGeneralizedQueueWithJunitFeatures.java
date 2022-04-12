package algs.chap01.sec1_3.queue;

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
    int n = 10;

    for (int i = 0; i < n; i++) {
      queue.insert(i);
    }

    for (int i = n-1; i >= 0; i--) {
      assertEquals(i, queue.delete(i));
    }

    n = 5;
    for (int i = 0; i < n; i++) {
      queue.insert(i);
    }

    for (int i = n-1; i >= 0; i--) {
      assertEquals(i, queue.delete(i));
    }
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