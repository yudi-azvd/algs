package AlgorithmsPrincetonCourse.Queue;

public class LinkedListQueueOfStrings implements IQueueOfStrings {
  private Node first, last;

  private class Node {
    String item;
    Node next;
  }

  public void enqueue(String item) {
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

  public String dequeue() {
    String item = first.item;
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