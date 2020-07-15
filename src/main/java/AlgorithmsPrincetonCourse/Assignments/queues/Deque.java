package AlgorithmsPrincetonCourse.Assignments.queues;

import java.util.NoSuchElementException;

public class Deque<Item> { // implements Iterable<Item> {
  private Node first, last;
  private int size;
  
  private class Node {
    Item item;
    Node next;
  }
  
  // construct an empty deque
  public Deque() {
    first = null;
    last = null;
    size = 0;
  }

  // is the deque empty?
  public boolean isEmpty() {
    return first == null;
  }

  // return the number of items on the deque
  public int size() {
    return size;
  }

  // add the item to the front
  public void addFirst(Item item) {
    validate(item);

    Node node = new Node();
    node.item = item;
    node.next = first;
    first = node;
    size++;
  }

  // add the item to the back
  public void addLast(Item item) {
    validate(item);

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

  // remove and return the item from the front
  public Item removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot call removeLast on an empty deque.");
    }

    Item item = first.item;
    first = first.next;
    size--;

    return item;
  }

  // remove and return the item from the back
  public Item removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot call removeLast on an empty deque.");
    }

    Item item = first.item;
    first = first.next;

    if (isEmpty()) {
      last = null;
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
  // public Iterator<Item> iterator() {
    // return new Iterator
  // }

  // unit testing (required)
  public static void main(String[] args) {
    Deque<String> d = new Deque<>();

    d.addFirst("a");
    d.addFirst("b");

    System.out.println(d.removeFirst());
    System.out.println(d.removeFirst());
  }
}