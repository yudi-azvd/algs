package AlgorithmsPrincetonCourse.Sorting;

public interface IMaxPQ<Key extends Comparable<Key>> {
  void insert(Key v);

  Key max();

  Key delMax();

  boolean isEmpty();

  int size();

  int getInsertionCount();

  int getArrayAccessCount();
}
