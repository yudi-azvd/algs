package algs.Assignments.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDeque<Item> implements Iterable<Item>, IDeque<Item> {
  private Node<Item> first, last;
  private int size;
  
  private static class Node<Item> {
    Item item;
    Node<Item> previous;
    Node<Item> next;
  }
  
  // construct an empty deque
  public LinkedListDeque() {
    first = null;
    last = null;
    size = 0;
  }

  // is the deque empty?
  public boolean isEmpty() {
    return first == null || last == null;
  }

  // return the number of items on the deque
  public int size() {
    return size;
  }

  // add the item to the front
  public void addFirst(Item item) {
    validate(item);

    Node<Item> node = new Node<>();
    node.item = item;
    node.next = first;
    node.previous = null;

    if (isEmpty()) {
      last = node;
    }
    else {
      first.previous = node;
    }

    first = node;
    size++;
  }

  // add the item to the back
  public void addLast(Item item) {
    validate(item);

    Node<Item> oldLast = last; // agora oldlast é o ante penúltimo
    last = new Node<Item>();

    last.item = item;
    last.next = null;
    last.previous = oldLast;

    if (isEmpty()) {
      first = last;
    }
    else {
      oldLast.next = last;
    }

    size++;
  }

  // remove and return the item from the front
  public Item removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot call removeLast on an empty deque.");
    }

    Item item = first.item;
    first = first.next;

    if (first != null) {
      first.previous = null;
    }
    else {
      last = null;
    }

    size--;

    return item;
  }

  // remove and return the item from the back
  public Item removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot call removeLast on an empty deque.");
    }

    Item item = last.item;
    
    if (size == 1) {
      first = null;
      last = null;
    }
    else if (size > 1) {
      last = last.previous;
      // last.next.previous = null; // precisa?
      last.next = null;
    }

    size--;

    return item;
  }

  private void validate(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Null argument not accepted.");
    }
  }

  // return an iterator over items in order from front to back
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    private Node<Item> current = first;

    public boolean hasNext() {
      return current != null;
    }

    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }

      Item item = current.item;
      current = current.next;

      return item;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  // unit testing (required)
  public static void main(String[] args) {
    LinkedListDeque<String> d = new LinkedListDeque<>();

    d.addFirst("a");
    d.addFirst("b");

    System.out.println(d.removeLast());

    // System.out.println(d.removeFirst());
    // System.out.println(d.removeFirst());
  }
}