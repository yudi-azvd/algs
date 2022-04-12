package algs.chap04.undirgraph;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MyDegreesOfSeparation {
  public static void main(String[] args) {
    // MySymbolGraph sg = new MySymbolGraph(args[0], args[1]);
    MySymbolGraph sg = new MySymbolGraph("algs4-data/movies.txt", "/");
    String source = "Bacon, Kevin";
    Graph g = sg.graph();

    // String source = args[2];
    if (!sg.contains(source)) {
      System.out.println(source + " not in database");
      return;
    }

    int src = sg.index(source);
    BreadthFirstPaths paths = new BreadthFirstPaths(g, src);

    while (!StdIn.isEmpty()) {
      String sink = StdIn.readLine();
      if (sg.contains(sink)) {
        int t = sg.index(sink);
        if (paths.hasPathTo(t))
          for (int v : paths.pathTo(t))
            StdOut.println("  " + sg.name(v));
        else
          StdOut.println("not connected");
      } else
        StdOut.println("not in database");
    }
  }
}
