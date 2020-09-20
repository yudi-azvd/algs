package AlgorithmsPrincetonCourse.Sorting;

import java.util.Arrays;

public class Merge {
  public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
    assert isSorted(a, lo, mid);
    assert isSorted(a, mid+1, hi);
    
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }
    
    int i = lo, j = mid+1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid)
        a[k] = aux[j++];
      else if (j > hi)
        a[k] = aux[i++];
      else if (aux[j] < aux[i])
        a[k] = aux[j++];
      else
        a[k] = aux[i++];
    }

    assert isSorted(a, lo, hi);
  }
  
  public static boolean isSorted(int[] a, int lo, int hi) {
    for (int i = lo+1; i <= hi; ++i) {
      if (a[i-1] > a[i]) {
        return false;
      }
    }
    
    return true;
  }
  
  public static void sort(int[] a, int[] aux, int lo, int hi) {
    if (hi <= lo) 
      return;
    
    int mid = lo + (hi - lo)/2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid+1, hi);
    merge(a, aux, lo, mid, hi);
  }

  public static void sort(int[] a) {
    int[] aux = new int[a.length];

    sort(a, aux, 0, a.length-1);
  }

  public static void main(String[] args) {
    int[] a = new int[] {
      13, 15,
      1, 9,
      10,
      6,
      6,
      2, 
      7
    };  

    sort(a);

    System.out.println(Arrays.toString(a));
  }
}
