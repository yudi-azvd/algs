package AlgorithmsPrincetonCourse.Stack;

public class Stack<Item> implements IStack<Item> {
  Node first = null;

  private class Node {
    Item item;
    Node next;
  }

  public void push(Item item) {
    Node node = new Node();
    node.item = item;
    node.next = first;
    first = node;
  }

  public Item pop() {
    Item item = first.item;
    first = first.next;

    return item;
  }

  public boolean isEmpty() {
    return first == null;
  }
}