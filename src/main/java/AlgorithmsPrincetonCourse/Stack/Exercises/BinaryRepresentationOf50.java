package AlgorithmsPrincetonCourse.Stack.Exercises;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

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