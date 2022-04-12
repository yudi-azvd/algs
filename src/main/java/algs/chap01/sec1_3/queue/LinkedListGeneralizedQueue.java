package algs.chap01.sec1_3.queue;

import java.util.NoSuchElementException;

public class LinkedListGeneralizedQueue<Item> implements IGeneralizedQueue<Item> {
  private Node<Item> first, last;
  int size;

  // por que estática?
  private static class Node<Item> {
    Item item;
    Node<Item> next;
  }

  public LinkedListGeneralizedQueue() {
    first = null;
    last = null;
    size = 0;
  }

  @Override
  public boolean isEmpty() {
    return first == null;
  }

  @Override
  public void insert(Item x) {
    Node<Item> newLast = new Node<>();    
    newLast.item = x;
    newLast.next = null;

    if (isEmpty()) {
      first = newLast;
    }
    else {
      last.next = newLast;
    }

    size++;
    last = newLast;
  }

  @Override
  public Item delete(int k) {
    if (isEmpty())
      throw new NoSuchElementException();

    if (k > size-1)
      throw new NoSuchElementException();
    
    if (k == 0) {
      Item item = first.item;
      first = first.next;
      size--;
      return item;
    }

    int kCounter = 0;
    Node<Item> node = first;

    while (kCounter < k-1) {
      node = node.next;
      kCounter++;
    }

    Item item = node.next.item;
    node.next = node.next.next;
    size--;
    return item;
  }

  @Override
  public String toString() {
    return "LinkedListGeneralizedQueue";
  }
}