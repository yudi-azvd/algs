package AlgorithmsPrincetonCourse.Sorting;

public class Insertion {
  public static void sort(int[] a) { // Sort a[] into increasing order.
  int N = a.length;
  for (int i = 1; i < N; i++) { // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
    for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
      exch(a, j, j-1);
    }
  }

  public static void sort(int[] a, int lo, int hi) { // Sort a[] into increasing order.
  for (int i = lo+1; i < hi+1; i++) { // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
    for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
      exch(a, j, j-1);
    }
  }

  private static boolean less(int v, int w) { 
    return v < (w); 
  }

  private static void exch(int[] a, int i, int j) { 
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
}
