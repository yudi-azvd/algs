package DrawExamples;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Example2 {
  public static void main(String[] args) {
    int N = 100;
    double[] arr = new double[N];

    for (int i = 0; i < N; i++) {
      arr[i] = StdRandom.uniform();
    }

    final double factor = 4;
    for (int i = 0; i < N; i++) {
      double x = 1.0*i/N;
      double y = arr[i]/factor;
      double rw = 0.5/N;
      double rh = arr[i]/factor;
      StdDraw.filledRectangle(x, y, rw, rh);
    }
  }
}