package AlgorithmsPrincetonCourse.Sorting;

/**
 * <code>exercise-2.4.3</code> unordered array
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
    if (size() > array.length/2) {
      resizeTo(array.length*2);
    }

    array[tail++] = v;
  }

  public Key max() {
    Key currentMax = (Key) array[head];
    for (int i = head+1; i < tail; i++) {
      Key newKey = (Key) array[i];
      if (newKey.compareTo(currentMax) > 0)
        currentMax = (Key) array[i];
    }

    return currentMax;
  }

  public Key delMax() {
    return (Key) array[0];
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
