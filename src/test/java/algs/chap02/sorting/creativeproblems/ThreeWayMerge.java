package algs.chap02.sorting.creativeproblems;

import java.util.Arrays;

/**
 * <code>creative-problem-2.2.22</code>
 * 
 * <p>3-way merge; three way merge
 */
public class ThreeWayMerge {
  public static void merge(int[] a, int[] aux, int lo, int loMid, int hiMid, int hi) {
    assert isSorted(a, lo, loMid);
    assert isSorted(a, loMid, hiMid);
    assert isSorted(a, hiMid, hi);

    for (int w = lo; w <= hi; w++) {
      aux[w] = a[w];
    }

    int i = lo, j = loMid, k = hiMid;
    for (int w = lo; w < hi; w++) {
      // verificar qual é menor (usar Insertion.sort num array de 3 itens?)
      if (i > loMid-1) {

      } 
      else if (j > hiMid-1) {

      }
      else if(k > hi) {
        
      }

      // a[w] = aux[i++/j++/k++]
    }
    
    assert isSorted(a, lo, hi);
  }

  private static void sort(int[] a, int[] aux, int lo, int hi) {
    // talvez esse teste tenha que ser mudado
    // talvez seja hi/3 <= lo ou hi/2 <= lo
    if (hi <= lo) return;

    // int mid = (lo + hi)/2;
    // sort(aux, a, lo, mid);
    // sort(aux, a, mid+1, hi);
    // merge(a, aux, lo, mid, hi);
    
    // 3-way sort
    int loMid = (hi-lo+1)/3;
    int hiMid = ((hi-lo+1)*2)/3;
    sort(aux, a, lo, loMid);
    sort(aux, a, loMid, hiMid);
    sort(aux, a, hiMid, hi);
    merge(a, aux, lo, loMid, hiMid, hi);

    assert isSorted(aux, lo, hi);
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

    assert isSorted(a, 0, a.length-1);

    System.out.println(Arrays.toString(a));
  }
}
