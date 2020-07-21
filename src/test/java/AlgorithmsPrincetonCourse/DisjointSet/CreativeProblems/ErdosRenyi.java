package AlgorithmsPrincetonCourse.DisjointSet.CreativeProblems;

import edu.princeton.cs.algs4.StdRandom;
// import edu.princeton.cs.algs4.UF;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class ErdosRenyi {
  public static int countGeneratedPairs;

  public static void main(String[] args) {
    int N = 400;
    System.out.println(count(N));
  }
  
  public static int count(int N) {
    int connections = 0;
    countGeneratedPairs = 0;

    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);

    // UF uf = new UF(N);
  
    while (!(uf.count() == 1)) {
      int p = StdRandom.uniform(N);
      int q = StdRandom.uniform(N);

      countGeneratedPairs++;
  
      if (uf.find(p) != uf.find(q)) {
        uf.union(p, q);
        connections++;
      }
    }
    
    return connections;
  }
}