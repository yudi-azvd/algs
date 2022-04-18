package algs.ch1.sec1_2_abstractdata.exercises;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * <code>exercise-1.2.10</code>
 */
public class VisualCounter {
  private int N;
  private int max;
  private int counter;
  private int operationsCounter;

  public VisualCounter(int N, int max) {
    this.N = N;
    this.max = max;
    counter = 0;
    operationsCounter = 0;
    StdDraw.setXscale(-1, N);
    StdDraw.setYscale(-max-2, max+2);
    StdDraw.setPenColor();
    StdDraw.setPenRadius(.0075);
  }

  public int tally() {
    return counter;
  }

  public void increment() {
    if (operationsCounter > N)
      return;

    if (Math.abs(counter) <= max) {
      ++operationsCounter;
      ++counter;
      StdDraw.point(operationsCounter, counter);
    }
  }
  
  public void decrement() {
    if (operationsCounter > N)
      return;
    
    if (Math.abs(counter) <= max) {
      ++operationsCounter;
      --counter;
      StdDraw.point(operationsCounter, counter);
    }
  }

  public static void main(String[] args) {
    int N = 10_000, max = 200;
    VisualCounter counter = new VisualCounter(N, max);

    for (int i = 0; i < N; i++) {
      if (!StdRandom.bernoulli(.55)) {
        counter.increment();
      }
      else {
        counter.decrement();
      }
    }

    System.out.println("the end.");
  }
} 
