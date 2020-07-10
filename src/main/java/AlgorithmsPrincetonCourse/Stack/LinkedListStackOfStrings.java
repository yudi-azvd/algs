package AlgorithmsPrincetonCourse.Stack;

public class LinkedListStackOfStrings implements IStackOfStrings {
  Node first = null;

  private class Node {
    String item;
    Node next;
  }

  public void push(String item) {
    Node node = new Node();
    node.item = item;
    node.next = first;
    first = node;
  }

  public String pop() {
    String item = first.item;
    first = first.next;

    return item;
  }

  public boolean isEmpty() {
    return first == null;
  }
}