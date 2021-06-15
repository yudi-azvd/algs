package AlgorithmsPrincetonCourse.Sorting;

import java.util.Arrays;

/**
 * <code>exercise-2.4.3</code> unordered array
 * 
 * Acho que não performa muito bem quando o tamanho de array
 * é 1 ou 2.
 */
@SuppressWarnings("unchecked")
public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> implements IMaxPQ<Key> {
  private Object array[];
  private int head;
  private int tail;

  public UnorderedArrayMaxPQ() {
    head = 0;
    tail = 0;
    array = new Object[1];
  }

  public UnorderedArrayMaxPQ(int capacity) {
    array = new Object[capacity];
    head = 0;
    tail = 0;
  }

  public UnorderedArrayMaxPQ(Key[] a) {
    array = a;
    head = 0;
    tail = a.length;
  }

  public void insert(Key v) {
    if (size() >= array.length-1) {
      resizeTo(array.length*2);
    }

    array[tail++] = v;
  }

  public Key max() {
    int maxIndex = findMaxIndex();
    return (Key) array[maxIndex];
  }

  public Key delMax() {
    int maxIndex = findMaxIndex();
    Key k = (Key) array[maxIndex];

    Object[] firstHalf = Arrays.copyOfRange(array, 0, maxIndex);
    Object[] secondHalf = Arrays.copyOfRange(array, maxIndex+1, array.length);

    array = new Object[array.length];
    // merge first half and second half into array
    System.arraycopy(firstHalf, 0, array, 0, firstHalf.length);
    System.arraycopy(secondHalf, 0, array, firstHalf.length, secondHalf.length);

    if (size() > 0 && size() <= array.length/4+1) {
      resizeTo(array.length/2);
    }
    
    --tail;
    return k;
  }

  private int findMaxIndex() {
    int currentMaxIndex = 0;
    for (int i = head; i < tail; i++) {
      Key newKey = (Key) array[i];
      Key currentMax = (Key) array[currentMaxIndex];
      if (newKey.compareTo(currentMax) > 0)
        currentMaxIndex = i;
    }

    return currentMaxIndex;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    return tail-head;
  }

  private void resizeTo(int newSize) {
    Object[] newArray = new Object[newSize];
    int newArrayIndex = 0;

    for (int i = head; i < tail; ++i, ++newArrayIndex) {
      newArray[newArrayIndex] = array[i];
    }

    array = newArray;
    head = 0;
  }
}
