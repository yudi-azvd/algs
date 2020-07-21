package AlgorithmsPrincetonCourse.Stack.Exercises;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class InvertQueueWithStack {
  public static void main(String[] args) {
    Stack<Integer> stack =  new Stack<>();
    Queue<Integer> queue =  new Queue<>();

    for (int i = 0; i < 10; i++) {
      queue.enqueue(i);
    }
    
    StdOut.println(queue.toString());

    while (!queue.isEmpty())
      stack.push(queue.dequeue());

    while (!stack.isEmpty())
      queue.enqueue(stack.pop());

    StdOut.println(queue.toString());
  }
}