package algs.chap01.sec1_3.exercises;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * exercise-1.3.5
 */
public class BinaryRepresentationOf50 {
  public static void main(String[] args) {
    int N = 50;
    Stack<Integer> stack = new Stack<Integer>();

    while (N > 0) {
      stack.push(N % 2);
      N /= 2;
    }

    for (int d : stack) 
      StdOut.print(d);
    
      StdOut.println();
  }
}