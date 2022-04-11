package AlgorithmsPrincetonCourse.chap02.sorting;

import java.util.Arrays;

public class MergeBU {
  private static int aux[];

  public static void merge(int[] a, int lo, int mid, int hi) {
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
  }

  public static void sort(int[] a) {
    int N = a.length;
    aux = new int[N];

    for (int size = 1; size < N; size = size + size) {
      for (int lo = 0; lo < N-size; lo += size+size) {
        merge(a, lo, lo+size-1, Math.min(lo+size+size-1, N-1));
      }
    }
  }

  public static void main(String[] args) {
    int[] a = new int[] {
      13, 15, 1, 9, 10, 6, 6, 2, 7
      // 101, 97, 115, 121, 113, 117, 101, 115, 116, 105, 111, 110
    };  
    
    sort(a);

    System.out.println(Arrays.toString(a));
  }
}
