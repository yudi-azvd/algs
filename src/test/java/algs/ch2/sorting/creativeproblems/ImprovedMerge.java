package algs.ch2.sorting.creativeproblems;

import java.util.Arrays;
import algs.ch2.sorting.Insertion;

/**
 * <code>creative-problem-2.2.11</code>
 * <p>Improved merge; merge melhorado
 * 
 * <p>Usa as três melhorias discutidas no livro:
 * 
 * <ol>
 * <li> Usa {@link Insertion#sort(int[], int, int)} para ordenar pequenos 
 * subarrays.
 * 
 * <li> Verifica se o último elemento do primeiro subarray é menor que o primeiro
 * elemento do segundo subarray.
 * 
 * <li> Inversão de {@code a[]} e {@code aux[]} para não precisar fazer uma cópia do array.
 * </ol>
 * 
 * <p>Tive que dar uma olhada <a href="https://github.com/reneargento/algorithms-sedgewick-wayne/blob/master/src/chapter2/section2/Exercise11_Improvements.java"> 
 * aqui </a>pra conseguir a parte 3.
 * 
 * <p>Pior é que acho que não entendi completamente ainda.
 */
public class ImprovedMerge {
  private static int cutoff = 7;

  public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
    assert isSorted(a, lo, mid);
    assert isSorted(a, mid+1, hi);

    int i = lo, j = mid+1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid)          
        aux[k] = a[j++];
      else if (j > hi)      
        aux[k] = a[i++];
      else if (a[i] < a[j]) 
        aux[k] = a[i++];
      else                  
        aux[k] = a[j++];
    }

    assert isSorted(aux, lo, hi);
  }

  private static void sort(int[] a, int[] aux, int lo, int hi) {
    if (hi <= lo) return;

    if (hi <= lo +  cutoff - 1) {
      Insertion.sort(aux, lo, hi);
      return;
    }

    int mid = (lo + hi)/2;
    sort(aux, a, lo, mid);
    sort(aux, a, mid+1, hi);
    if (aux[mid] < aux[mid+1]) return;
    merge(a, aux, lo, mid, hi);

    assert isSorted(aux, lo, hi);
  }

  public static void sort(int[] a) {
    int[] aux = a.clone();

    sort(aux, a, 0, a.length-1);
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

