package AlgorithmsPrincetonCourse.chap02.sorting;


@SuppressWarnings("unchecked")
public class HeapMaxPQ<Key extends Comparable<Key>> implements IMaxPQ<Key>  {
  private Key[] pq;
  private int N = 0;
  private int arrayAccessCount = 0;

  public HeapMaxPQ(int maxN) {
    if (maxN <= 0)
      throw new IllegalArgumentException();
    pq = (Key[]) new Comparable[maxN+1];
    pq[0] = null;
  }

  public void insert(Key v) {
    arrayAccessCount = 1;
    pq[++N] = v;
    swim(N);
  }
  
  public Key max() {
    // ++arrayAccessCount;
    return pq[1];
  }

  public Key delMax() {
    arrayAccessCount = 3;
    Key max = pq[1];
    pq[1] = pq[N]; // root = pq[N-1]
    --N;
    sink(1);
    return max;
  }

  public boolean isEmpty() {
    return N==0;
  }

  public int size() {
    return N;
  }

  // Bottom-up reheapify
  private void swim(int k) {
    // enquanto k não é root E pai é menor que filho
    while (k > 1 && less(k/2, k)) {
      // troque posição de pai e filho
      exch(k/2, k);
      // o novo nó a ser analisado é o novo pai/antigo filho
      k = k/2;
    }
  }

  // Top-down reheapify
  private void sink(int k) {
    while (2*k <= N) {
      // j é o filho = filho da esquerda
      int j = 2*k;
      // se j não é o fim E filho da esquerda é menor do que o da direita
      if (j < N && less(j, j+1)) { ++j; } // filho = filho direita
      // se pai não é menor que o filho a ser trocado, termine o loop
      if (!less(k, j)) break; 
      // se não, troque pai e filho
      exch(k, j);
      // novo filho
      k = j;
    }
  }
  
  private boolean less(int i, int j) {
    arrayAccessCount += 2;
    return pq[i].compareTo(pq[j]) < 0;
  }
  
  private void exch(int i, int j) {
    arrayAccessCount += 3;
    Key tmp = pq[i];
    pq[i] = pq[j];
    pq[j] = tmp;
  }

  @SuppressWarnings("unused")
  private void swimRecursive(int k) {
    Key parent = pq[k/2];
    Key current = pq[k];
    while (k > 1) { // && parent.compareTo(current) < 0 // less(k/2, k)
      if (parent.compareTo(current) < 0) { 
        exch(k, k/2);
        swimRecursive(k/2);
      }
      break;
    }
    return;
  }

  @SuppressWarnings("unused")
  private void mysink(int k) {
    // enquanto não chega no fim do array?
    while (2*k <= N) {
      // se pai menor que os dois filhos
      if (less(k, k*2) && less(k, k*2+1)) {
        int maxChild = Math.max(k*2, k*2+1);
        exch(k, maxChild);
        k = maxChild;
      }
      // se pai menor que o filho da esquerda somente
      else if (less(k, k*2)) {
        exch(k, k*2);
        k = k*2;
      }
      // se pai menor que o filho da direta somente
      else if (less(k, k*2+1)) {
        exch(k, k*2+1);
        k = k*2+1;
      }
      else {}
    }
  }

  public int getArrayAccessCount() {
    return arrayAccessCount;
  }
}
