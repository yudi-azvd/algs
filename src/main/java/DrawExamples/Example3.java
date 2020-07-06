package DrawExamples;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Example3 {
  public static void main(String[] args) {
    int N = 100;
    double[] arr = new double[N];

    for (int i = 0; i < N; i++) {
      arr[i] = StdRandom.uniform();
    }

    Arrays.sort(arr);
    for (int i = 0; i < N; i++) {
      double x = 1.0*i/N;
      double y = arr[i]/2.0;
      double rw = 0.5/N;
      double rh = arr[i]/2.0;
      StdDraw.filledRectangle(x, y, rw, rh);
    }
  }
}