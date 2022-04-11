package AlgorithmsPrincetonCourse.chap02.sorting.exercises;

/**
 * <p>Classe para o exercício {@link MergeTDvsMergeBU}.
 * 
 * <p>É para ser igual ao {@link Merge}, mas conta o número de acessos 
 * ao array.
 */
public class CountMergeTD {
  private static int arrayAccessesCount = 0;

  public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
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
  
  private static void sort(int[] a, int[] aux, int lo, int hi) {
    if (hi <= lo) return;

    int mid = (lo + hi)/2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid+1, hi);
    merge(a, aux, lo, mid, hi);
  }
  
  public static int sort(int[] a) {
    arrayAccessesCount = 0;
    int[] aux = new int[a.length];

    sort(a, aux, 0, a.length-1);

    return arrayAccessesCount;
  }
}

