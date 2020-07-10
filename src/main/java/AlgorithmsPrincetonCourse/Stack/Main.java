package AlgorithmsPrincetonCourse.Stack;

import edu.princeton.cs.algs4.In;

public class Main {
  public static void main(String[] args) {
    // readTxt();
    randomTest();
  }

  public static void randomTest() {
    // LinkedListStackOfStrings stack = new LinkedListStackOfStrings();
    // ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
    IStackOfStrings stack = new ResizingArrayStackOfStrings();

    stack.push("1");
    stack.push("2");
    stack.push("3");
    stack.push("4");
    stack.push("5");

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