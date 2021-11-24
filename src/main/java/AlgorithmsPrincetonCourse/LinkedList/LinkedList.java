package AlgorithmsPrincetonCourse.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item> implements Iterable<Item> {
  private Node<Item> first, last;
  private int size;
  
  private static class Node<Item> {
    Item item;
    Node<Item> previous;
    Node<Item> next;
  }
  
  // constroi uma lista lincada vazia
  public LinkedList() {
    first = null;
    last = null;
    size = 0;
  }

  // a lista lincada está vazia?
  public boolean isEmpty() {
    return first == null || last == null;
  }

  // returna o número de itens na lista
  public int size() {
    return size;
  }

  // adiciona item no início da lista
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

  // adiciona item no fim da lista
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

  // remove e retorna o item do início da lista
  public Item removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot call removeLast on an empty linked list.");
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

  // remove e retorna o item do fim da lista
  public Item removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException("Cannot call removeLast on an empty linked list.");
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

  // remove e retorna o item depois do nó passado como parâmetro
  // deve ser usado apenas internamente
  private Item removeNode(Node<Item> node) {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    if (node == null) {
      throw new IllegalArgumentException("node cannot be null");
    }

    Item item;
    if (node == first) {
      item = first.item;
      first = first.next;
      first.previous = null;
    }
    else if (node == last) {
      item = last.item;
      last = last.previous;
      last.next = null;
    }
    else { // está entre dois nós não nulos
      item = node.item;
      node.previous.next = node.next;
      node.next.previous = node.previous;
    }
    
    size--;
    return item;
  }

  // estratégia move-to-front
  // adiciona um item no começo da lista se esse não está na lista.
  // caso contrário, remove o item de sua posição na lista e o adi-
  // ciona no começo da lista.
  public void moveToFront(Item item) {
    if (isEmpty()) {
      addFirst(item);
      return ;
    }

    Node<Item> node = first;
    Item existingItem = null;

    while (node != null) {
      if (node.item.equals(item)) {
        existingItem = removeNode(node);
        addFirst(existingItem);
        return;
      }

      node = node.next;
    }

    addFirst(item);
  }

  public Item peekFront() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    return first.item;
  }

  private void validate(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Null argument not accepted.");
    }
  }

  @Override
  public String toString() {
    String result = "";
    Node<Item> node = first;

    while (node != null) {
      result += "" + node.item + " ";
      node = node.next;
    }

    return result;
  }

  // returna um iterador sobre os itens, indo do início ao fim da lista
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
}