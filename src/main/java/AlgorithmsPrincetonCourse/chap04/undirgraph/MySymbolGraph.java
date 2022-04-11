package AlgorithmsPrincetonCourse.chap04.undirgraph;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MySymbolGraph {
  private ST<String, Integer> st;
  private String[] keys;
  private Graph g;

  public MySymbolGraph(String stream, String sp) {
    st = new ST<String, Integer>();

    In in = new In(stream);
    String[] a;
    while (in.hasNextLine()) {
      a = in.readLine().split(sp);
      for (int i = 0; i < a.length; i++)
        if (!st.contains(a[i]))
          st.put(a[i], st.size());
    }

    keys = new String[st.size()];
    for (String name : st.keys())
      keys[st.get(name)] = name;

    g = new Graph(st.size());
    in = new In(stream);
    while (in.hasNextLine()) {
      a = in.readLine().split(sp);
      int v = st.get(a[0]);
      for (int i = 1; i < a.length; i++)
        g.addEdge(v, st.get(a[i]));
    }
  }

  public boolean contains(String key) {
    return st.contains(key);
  }

  public int index(String key) {
    return st.get(key);
  }

  public String name(int v) {
    return keys[v];
  }

  public Graph graph() {
    return g;
  }

  public static void main(String[] args) {
    // String filename = "algs4-data/movies.txt";
    // String delim = "/";
    String filename = args[0];
    String delim = args[1];

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
