package AlgorithmsPrincetonCourse.chap04.undirgraph.exercises;

import AlgorithmsPrincetonCourse.chap04.undirgraph.MySymbolGraph;
import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdOut;

/**
 * <code>exercise-4.1.22</code> kevin bacon number
 */
public class _4_1_22 {
  public static void main(String[] args) {
    String filename = "algs4-data/movies.txt";
    String delim = "/";

    MySymbolGraph sg = new MySymbolGraph(filename, delim);
    Graph g = sg.graph();

    String source = "Bacon, Kevin";

    // 2011 oscar nominees: leading role
    // https://www.theguardian.com/film/2011/jan/25/oscar-nominations-lists-full-nominees
    String[] actors =
        {"Bardem, Javier", "Bridges, Jeff", "Eisenberg, Jesse", "Firth, Colin", "Franco, James",};

    StdOut.println("source: " + source);

    int src = sg.index(source);
    BreadthFirstPaths paths = new BreadthFirstPaths(g, src);

    for (String a : actors) {
      StdOut.print(a+ ": ");
      if (sg.contains(a)) {
        int t = sg.index(a);
        if (paths.hasPathTo(t)) {
          StdOut.println(paths.distTo(t)/2);
          for (int v : paths.pathTo(t))
            StdOut.println("  " + sg.name(v));
        }
        else
          StdOut.println(" not connected");
      } else
        StdOut.println(" not in database");
    }
  }
}
