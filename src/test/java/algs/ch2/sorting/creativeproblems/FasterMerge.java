package algs.ch2.sorting.creativeproblems;

import java.util.Arrays;

/**
 * creative-problem-2.2.10
 */
public class FasterMerge {
  public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
    // copiar 1a metade
    for (int k = lo; k <= mid; k++) {
      aux[k] = a[k];
    }

    // copiar 2a metade em ordem descrescente
    int r = 0; // reversed index
    for (int k = mid+1; k <= hi; k++, r++) {
      aux[hi-r] = a[k];
    }

    // k é iterador de a[]
    // int i = lo, j = mid+1;
    int i = lo, j = hi;
    for (int k = lo; k <= hi; k++) {
      if (aux[i] < aux[j])
        a[k] = aux[i++];
      else
        a[k] = aux[j--];
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
  
  public static boolean isSorted(int[] a, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++)
      if (a[i-1] > a[i])
        return false;
    return true;
  }
  
  public static void sort(int[] a) {
    int[] aux = new int[a.length];
    
    sort(a, aux, 0, a.length-1);
  }
  
  public static void main(String[] args) {
    int[] a = new int[] {
      // 13, 15, 1, 9, 10, 6, 6, 2, 7
      101, 97, 115, 121, 113, 117, 101, 115, 116, 105, 111, 110
      // 1, 2, 9, 13, 15,  6, 6, 7, 10
      // 1, 2, 3, 4, 5, 6, 7, 8, 9
      // 5, 6, 1, 2, 7, 3, 9, 4, 8
    };  
    // int[] aux = new int[a.length];
    
    sort(a);
    
    System.out.println(Arrays.toString(a));
    // merge(a, aux, 0, a.length/2, a.length-1);
    
    System.out.println(Arrays.toString(a));
  }
}
