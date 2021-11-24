package AlgorithmsPrincetonCourse.Queue;

import java.util.NoSuchElementException;

public class LinkedListQueue<Item> implements IQueue<Item> {
  private Node first, last;
  private int size;

  private class Node {
    private Item item;
    private Node next;
  }

  public LinkedListQueue() {
    first = null;
    last = null;
    size = 0;
  }

  public LinkedListQueue(LinkedListQueue<Item> source) {
    if (source == null) {
      throw new IllegalArgumentException("queue cannot be null");
    }

    Node sourceNode = source.first;

    while (sourceNode != null) {
      this.enqueue(sourceNode.item);
      sourceNode = sourceNode.next;
    }
  }

  public void enqueue(Item item) {
    Node oldLast = last; // agora oldlast é o ante penúltimo
    last = new Node();

    last.item = item;
    last.next = null;

    if (isEmpty()) {
      first = last;
    }
    else {
      oldLast.next = last;
    }

    size++;
  }

  public Item dequeue() {
    Item item = first.item;
    first = first.next;

    if (isEmpty()) {
      last = null;
    }

    size--;
    return item;
  }

  public int size() {
    return size;
  }

  public Item peek() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    return first.item;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public boolean isCopyOf(LinkedListQueue<Item> that) {
    if (this.size() != that.size()) {
      return false;
    }

    if (this == that) {
      return false;
    }

    Node thisNode = this.first;
    Node thatNode = that.first;

    while (thisNode != null && thatNode != null) {
      if (thisNode == thatNode)
        return false;

      if (!thisNode.item.equals(thatNode.item))
        return false;

      thatNode = thatNode.next;
      thisNode = thisNode.next;
    }

    return true;
  }

  public boolean equals(LinkedListQueue<Item> that) {
    Node thisNode = this.first, thatNode = that.first;

    while (thisNode != null && thatNode != null) {
      if (!thisNode.item.equals(thatNode.item))
        return false;
      thisNode = thisNode.next;
      thatNode = thatNode.next;
    }

    if (thisNode == null && thatNode != null)
      return false;
    if (thisNode != null && thatNode == null)
      return false;

    return true;
  }

  @Override
  public String toString() {
    String result = "";
    Node node = first;

    while (node != null) {
      result += node.item + " ";
      node = node.next;
    }

    return result;
  }
}