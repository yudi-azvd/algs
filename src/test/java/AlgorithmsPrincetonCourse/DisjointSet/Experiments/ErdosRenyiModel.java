package AlgorithmsPrincetonCourse.DisjointSet.Experiments;

import AlgorithmsPrincetonCourse.DisjointSet.CreativeProblems.ErdosRenyi;
import edu.princeton.cs.algs4.StdDraw;

public class ErdosRenyiModel {
  public static void main(String[] args) {
    int N = 3000;

    StdDraw.setXscale(0, N*1.1);
    StdDraw.setYscale(0, N*4);
    
    for (int i = 1; i < N; i += 2) {
      executeExperiment(i);
    }

    System.out.println("done");
  }

  public static void executeExperiment(int N) {
    StdDraw.setPenColor(StdDraw.GRAY);
    StdDraw.point(N, hypotheticalFunction(N));
    
    StdDraw.setPenColor(StdDraw.RED);
    ErdosRenyi.count(N);
    StdDraw.point(N, ErdosRenyi.countGeneratedPairs);
    
    // StdDraw.setPenColor(StdDraw.GREEN);
    // StdDraw.point(i, i);
  }

  public static double hypotheticalFunction(int N) {
    return 0.5*N*Math.log(N);
  }
}