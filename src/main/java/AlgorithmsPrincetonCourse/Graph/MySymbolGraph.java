package AlgorithmsPrincetonCourse.Graph;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MySymbolGraph {
  private ST<String, Integer> st;
  private String[] keys;
  private Graph g;

  MySymbolGraph(String filename, String delim) {
    st = new ST<>();
    In in = new In(filename);

    while (in.hasNextLine()) {
      StdOut.println(in.readLine());
    }
  }

  boolean contains(String key) {
    return st.contains(key);
  }

  int index(String key) {
    return st.get(key);
  }

  String name(int v) {
    return keys[v];
  }

  Graph graph() {
    return g;
  }


  public static void main(String[] args) {
    String filename = "algs4-data/routes.txt";
    String delim = " ";

    MySymbolGraph sg = new MySymbolGraph(filename, delim);
    Graph g = sg.graph();

    while (StdIn.hasNextLine()) {
      String source = StdIn.readLine();
      for (int w : g.adj(sg.index(source))) {
        StdOut.println("   " + sg.name(w));
      }
    }
  }
}
