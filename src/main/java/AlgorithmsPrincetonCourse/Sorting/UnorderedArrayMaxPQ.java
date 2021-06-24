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
  private int tail;
  private int insertionCount = 0;
  private int arrayAccessCount = 0;

  public UnorderedArrayMaxPQ() {
    array = new Object[1];
    tail = 0;
  }

  public UnorderedArrayMaxPQ(int capacity) {
    array = new Object[capacity];
    tail = 0;
  }

  public UnorderedArrayMaxPQ(Key[] a) {
    array = a;
    tail = a.length;
  }

  public void insert(Key v) {
    ++insertionCount;
    arrayAccessCount = 0;
    if (size() >= array.length-1) {
      resizeTo(array.length*2);
    }
    // resizeTo(array.length+1);
    
    ++arrayAccessCount;
    array[tail++] = v;
  }

  public int getInsertionCount() {
    return insertionCount;
  }

  public int getArrayAccessCount() {
    return arrayAccessCount;
  }

  public Key max() {
    int maxIndex = findMaxIndex();
    return (Key) array[maxIndex];
  }

  public Key delMax() {
    int maxIndex = findMaxIndex(); // +N
    Key k = (Key) array[maxIndex];

    Object[] firstHalf = Arrays.copyOfRange(array, 0, maxIndex); // +N/2
    Object[] secondHalf = Arrays.copyOfRange(array, maxIndex+1, tail); // +N/2
    array = new Object[array.length];
    // merge first half and second half into array
    System.arraycopy(firstHalf, 0, array, 0, firstHalf.length); // N/2
    System.arraycopy(secondHalf, 0, array, firstHalf.length, secondHalf.length); // N/2
    // arrayAccessCount += array
    if (size() > 0 && size() <= array.length/4+1) {
      resizeTo(array.length/2); // N/2
    }
    
    --tail;
    return k;
  }

  private int findMaxIndex() {
    int currentMaxIndex = 0;
    for (int i = 0; i < tail; i++) {
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
    return tail;
  }

  private void resizeTo(int newSize) {
    Object[] newArray = new Object[newSize];
    int newArrayIndex = 0;

    for (int i = 0; i < tail; ++i, ++newArrayIndex) {
      newArray[newArrayIndex] = array[i];
      arrayAccessCount++;
    }

    array = newArray;
  }
}
