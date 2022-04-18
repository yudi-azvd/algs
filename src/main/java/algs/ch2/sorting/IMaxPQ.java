package algs.ch2.sorting;

public interface IMaxPQ<Key extends Comparable<Key>> {
  void insert(Key v);

  Key max();

  Key delMax();

  boolean isEmpty();

  int size();
}
