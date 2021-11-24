package AlgorithmsPrincetonCourse.Sorting;

import java.util.Arrays;

/**
 * <p>Versão mais simples do algoritmo Mergesort, sem melhorias.
 * 
 * <p>Para uma versão melhorada, cheque 
 * {@link Sorting.CreativeProblems#ImprovedMerge},
 * procurando por <code>creative-problem-2.2.11</code>.
 */
public class Merge {
  public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
    assert isSorted(a, lo, mid);
    assert isSorted(a, mid+1, hi);

    // copiar a[] em aux[]
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }
    
    // k é iterador de a[]
    int i = lo, j = mid+1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid)
        a[k] = aux[j++];
      else if (j > hi)
        a[k] = aux[i++];
      else if (aux[i] < aux[j])
        a[k] = aux[i++];
      else
        a[k] = aux[j++];
    }

    assert isSorted(a, lo, hi);
  }

  
  private static void sort(int[] a, int[] aux, int lo, int hi) {
    if (hi <= lo) return;

    int mid = (lo + hi)/2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid+1, hi);
    merge(a, aux, lo, mid, hi);

    assert isSorted(a, lo, hi);
  }

  public static void sort(int[] a) {
    int[] aux = new int[a.length];

    sort(a, aux, 0, a.length-1);
  }

  public static boolean isSorted(int[] a, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++)
      if (a[i-1] > a[i])
        return false;
    return true;
  }


  public static void main(String[] args) {
    int[] a = new int[] {
      // 13, 15, 1, 9, 10, 6, 6, 2, 7
      101, 97, 115, 121, 113, 117, 101, 115, 116, 105, 111, 110
      // 1, 2, 9, 13, 15,  6, 6, 7, 10
    };  
    
    sort(a);

    // merge(a, aux, 0, a.length/2, a.length-1);

    System.out.println(Arrays.toString(a));
  }
}
