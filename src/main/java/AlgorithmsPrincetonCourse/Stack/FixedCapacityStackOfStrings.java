package AlgorithmsPrincetonCourse.Stack;

import edu.princeton.cs.algs4.In;

public class FixedCapacityStackOfStrings implements IStackOfStrings {
  private String[] stack;
  private int N = 0;

  public FixedCapacityStackOfStrings(int capacity) {
    stack = new String[capacity];
  }

  public void push(String item) {
    stack[N++] = item;
  }

  public String pop() {
    String item = stack[--N];
    stack[N] = null;
    return item;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public static void main(String[] args) {
    // readTxt();
    randomTest();
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

    FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(100);

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