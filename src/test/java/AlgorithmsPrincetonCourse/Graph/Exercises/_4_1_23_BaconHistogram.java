package AlgorithmsPrincetonCourse.Graph.Exercises;

import java.util.ArrayList;
import AlgorithmsPrincetonCourse.Graph.MySymbolGraph;
import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

/**
 * <code>exercise-4.1.23</code> kevin bacon number histogram
 */
public class _4_1_23_BaconHistogram {
  public static void main(String[] args) {
    String filename = "algs4-data/movies.txt";
    String delim = "/";

    MySymbolGraph sg = new MySymbolGraph(filename, delim);
    Graph g = sg.graph();

    String source = "Bacon, Kevin";
    StdOut.println("source: " + source);

    int src = sg.index(source);
    BreadthFirstPaths paths = new BreadthFirstPaths(g, src);
    ArrayList<String> performers = getPerformersFrom(sg);

    // bacon numbers -> #perf com esse bacon number
    ST<Integer, Integer> baconHistogram = new ST<>();
    int baconNumber = 0, notConnectedToSource = 0;
    for (String p : performers) {
      int pv = sg.index(p);
      if (paths.hasPathTo(pv)) {
        baconNumber = paths.distTo(pv) / 2;
        if (!baconHistogram.contains(baconNumber))
          baconHistogram.put(baconNumber, 1);
        else
          baconHistogram.put(baconNumber, baconHistogram.get(baconNumber) + 1);
      } else {
        notConnectedToSource++;
      }
    }

    for (Integer bn : baconHistogram.keys())
      System.out.printf("%3d: %d\n", bn, baconHistogram.get(bn));
    System.out.printf("not connected to %s\n", source);
    System.out.printf("   : %d\n", notConnectedToSource);
    System.out.println();
    System.out.printf(" Performers count by str: %d\n", performers.size());
    System.out.printf("Performers count by hist: %d\n",
        countPerfByHistogram(baconHistogram, notConnectedToSource));
  }

  static ArrayList<String> getPerformersFrom(MySymbolGraph sg) {
    int vertices = sg.graph().V();
    ArrayList<String> performers = new ArrayList<>();
    for (int i = 0; i < vertices; i++)
      if (!sg.name(i).matches("^.*\\(\\d{4}\\)$"))
        performers.add(sg.name(i));
    return performers;
  }

  public static int countPerfByHistogram(ST<Integer, Integer> histogram, int notConnected) {
    int sum = 0;
    for (Integer key : histogram.keys())
      sum += histogram.get(key);
    return sum + notConnected;
  }
}
