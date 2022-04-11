package AlgorithmsPrincetonCourse.chap02.sorting.exercises;

import java.util.Arrays;

/**
 * <p>Classe para o exercício {@link MergeTDvsMergeBU}.
 * 
 * <p>É para ser igual ao {@link MergeBU}, mas conta o número de acessos 
 * ao array.
 */
public class CountMergeBU {
  private static int aux[];

  private static int arrayAccessesCount = 0;

  public static void merge(int[] a, int lo, int mid, int hi) {
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k]; 
      arrayAccessesCount += 2;
    }

    int i = lo, j = mid+1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
        arrayAccessesCount += 2;
      }
      else if (j > hi) {
        a[k] = aux[i++];
        arrayAccessesCount += 2;
      }
      else if (aux[i] < aux[j]) {
        a[k] = aux[i++];
        arrayAccessesCount += 4;
      }
      else {
        a[k] = aux[j++];
        // 2 desse else + 2 do teste do else if anterior
        arrayAccessesCount += 4;
      }
    }
  }

  public static int sort(int[] a) {
    int N = a.length;
    aux = new int[N];
    arrayAccessesCount = 0;

    for (int size = 1; size < N; size = size + size) {
      // System.out.println("size = " + size);
      for (int lo = 0; lo + size < N; lo += size + size) {
        // System.out.println("merge(a," + lo + ","+ (lo+size-1) +","+Math.min(lo+size+size-1, N-1)+");");
        merge(a, lo, lo+size-1, Math.min(lo+size+size-1, N-1));
      }
    }

    return arrayAccessesCount;
  }

  public static void main(String[] args) {
    int[] a = new int[] {
      // 13, 15, 1, 9, 10, 6, 6, 2, 7, 10, 9, 8, 7, 3, 4, 5
      101, 97, 115, 121, 113, 117, 101, 115, 116, 105, 111, 110
    };  
    
    sort(a);

    System.out.println(Arrays.toString(a));
  }
}
