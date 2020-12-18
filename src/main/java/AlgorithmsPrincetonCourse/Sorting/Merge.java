package AlgorithmsPrincetonCourse.Sorting;

import java.util.Arrays;

public class Merge {
  public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
    assert isSorted(a, lo, mid);
    assert isSorted(a, mid+1, hi);

    // k é iterador de a[]
    int i = 0, j = 0;
    for (int k = 0; k < a.length; k++) {
      if (aux[i] < aux[j]) {
        a[k] = aux[i];
        i++;
      }
      else {
        a[k] = aux[j];
        j++;
      }
    }
  }
  
  public static boolean isSorted(int[] a, int lo, int hi) {
    for (int i = 1; i < a.length; i++)
      if (a[i-1] > a[i])
        return false;
    return true;
  }
  
  public static void sort(int[] a, int[] aux, int lo, int hi) {
  }

  public static void sort(int[] a) {
  }

  public static void main(String[] args) {
    int[] a = new int[] {
      13, 15, 1, 9, 10, 6, 6, 2, 7
    };  

    sort(a);

    System.out.println(Arrays.toString(a));
  }
}
