package algs.ch2.sorting;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

public class TopM {
  public static void main(String[] args) {
    int M = 5;
    In in = new In("algs4-data/tinyBatch.txt");

    MinPQ<Transaction> pq = new MinPQ<>(M+1);
    while (!in.isEmpty()) {
      pq.insert(new Transaction(in.readLine()));
      if (pq.size() > M)
        pq.delMin();
    }

    Stack<Transaction> stack = new Stack<>();
    while (!pq.isEmpty()) stack.push(pq.delMin());
    for (Transaction t : stack) StdOut.println(t);
  }
}
