package AlgorithmsPrincetonCourse.Stack;

import edu.princeton.cs.algs4.In;

public class LinkedListStackOfStrings {
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

  public static void main(String[] args) {
    readTxt();
    // randomTest();
  }

  public static void randomTest() {
    LinkedListStackOfStrings stack = new LinkedListStackOfStrings();

    stack.push("1");
    stack.push("2");
    stack.push("3");
    stack.push("4");

    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }

  public static void readTxt() {
    In in = new In("algs4-data/tobe.txt");

    LinkedListStackOfStrings stack = new LinkedListStackOfStrings();

    while (!in.isEmpty()) {
      String s = in.readString();

      if (s.equals("-")) {
        System.out.println(stack.pop());
      }
      else {
        stack.push(s);
      }
    }
  }
}