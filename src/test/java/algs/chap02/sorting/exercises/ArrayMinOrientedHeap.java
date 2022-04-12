package algs.chap02.sorting.exercises;

/**
 * <code>exercise-2.4.15</code>
 */
@SuppressWarnings("unchecked")
public class ArrayMinOrientedHeap {
  public static boolean check(Comparable[] a) {
    int N = a.length;
    for (int i = 2; i < N; i++) {
      if (less(a, i, i/2)) { // se o filho é menor que o pai
        return false;
      }
    }

    return true;
  }

  private static boolean less(Comparable[] a, int i, int j) {
    return a[i].compareTo(a[j]) < 0;
  }
}
