package algs.chap01.sec1_3.stack;

public class Stack<Item> implements IStack<Item> {
  private Node first;
  private int size;

  private class Node {
    Item item;
    Node next;
  }

  public Stack() {
    first = null;
    size = 0;
  }

  public Stack(Stack<Item> source) {
    Stack<Item> aux = new Stack<>();
    Stack<Item> aux2 = new Stack<>();
    Node sourceNode = source.first;

    while (sourceNode != null) {
      aux.push(sourceNode.item);
      sourceNode = sourceNode.next;
    }

    // se fosse uma lista duplamente encadeada
    // não precisaria dessa segunda parte
    while (!aux.isEmpty()) {
      aux2.push(aux.pop());
    }

    first = aux2.first;
    // já ta cheirando gambiarra
    size = aux2.size();
  }

  public void push(Item item) {
    Node node = new Node();
    node.item = item;
    node.next = first;
    first = node;
    size++;
  }

  public Item pop() {
    Item item = first.item;
    first = first.next;
    size--;
    return item;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public boolean isCopyOf(Stack<Item> that) {
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
}