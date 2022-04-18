package algs.ch1.sec1_2_abstractdata;

import edu.princeton.cs.algs4.StdRandom;

public class FlipsMax {
  public static Counter max(Counter x, Counter y) {
    if (x.tally() > y.tally())
      return x;
    return y;
  }

  public static void main(String[] args) {
    int T = 1000;
    Counter heads = new Counter("heads");
    Counter tails = new Counter("tails");

    for (int t = 0; t < T; t++) {
      if (StdRandom.bernoulli(.5))
        heads.increment();
      else
        tails.increment();
    }

    if (heads.tally() == tails.tally())
      System.out.println("tie!");
    else 
      System.out.println(max(heads, tails) + " wins!");
  }
}
