package algs.chap02.sorting;

/**
 * <code>exercise-2.4.3</code> ordered array
 */
@SuppressWarnings("unchecked")
public class OrderedArrayMaxPQ<Key extends Comparable<Key>> implements IMaxPQ<Key> {
  private Key array[];
  private int tail;
  private int delMaxCount = 0;
  private int arrayAccessCount = 0;

  public OrderedArrayMaxPQ() {
    tail = 0;
    array = (Key[]) new Comparable[1];
  }

  public OrderedArrayMaxPQ(int capacity) {
    array = (Key[]) new Comparable[capacity];
    tail = 0;
  }

  public OrderedArrayMaxPQ(Key[] a) {
    array = a;
    // Arrays.sort(array);
    tail = a.length;
  }

  public void insert(Key v) {
    arrayAccessCount = 0;
    int i;
    
    if (size() == array.length) {
      resizeTo(array.length*2);
    }

    int positionToInsert = 0;

    // procurar onde vai inserir
    for (i = 0; i < tail; ++i, ++positionToInsert) {
      if (v.compareTo((Key) array[i]) < 0) {
        positionToInsert = i;
        ++arrayAccessCount;
        break;
      }
    }

    // deslocar todo mundo pra direita a partir de positionToInsert
    for (i = tail-1; i >= positionToInsert; --i) {
      array[i+1] = array[i];
      arrayAccessCount += 2;
    }

    ++tail;
    ++arrayAccessCount;
    array[positionToInsert] = v;
  }

  // Na verdade retorna o delMaxCount mesmo.
  // Preguiça de implemntar.
  public int getInsertionCount() {
    return delMaxCount;
  }

  public int getArrayAccessCount() {
    return arrayAccessCount;
  }

  public Key max() {
    return (Key) array[tail-1];
  }
  
  public Key delMax() {
    ++delMaxCount;
    arrayAccessCount = 0;
    if (size() > 2 && size() <= array.length/4+1) {
      resizeTo(array.length/2);
    }

    arrayAccessCount += 2;
    Key max = (Key) array[tail-1];
    array[tail-1] = null;
    --tail;
    return max;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    return tail;
  }

  private void resizeTo(int newSize) {
    Key[] newArray = (Key[]) new Comparable[newSize];
    int newArrayIndex = 0;

    for (int i = 0; i < tail; ++i, ++newArrayIndex) {
      newArray[newArrayIndex] = array[i];
      ++arrayAccessCount;
    }

    array = newArray;
  }
}

