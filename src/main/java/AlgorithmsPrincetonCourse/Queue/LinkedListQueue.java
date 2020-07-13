package AlgorithmsPrincetonCourse.Queue;

public class LinkedListQueue<Item> implements IQueue<Item> {
  private Node first, last;

  private class Node {
    Item item;
    Node next;
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
  }

  public Item dequeue() {
    Item item = first.item;
    first = first.next;

    if (isEmpty()) {
      last = null;
    }

    return item;
  }

  public boolean isEmpty() {
    return first == null;
  }
}