package algs.ch4.sec4_1_undirgraph;

import java.util.ArrayList;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;


/**
 * Componente Conexas com BFS
 */
@SuppressWarnings("unchecked")
public class CCBfs {
  private int count;
  private int[] ids;
  private boolean[] visited;

  public CCBfs(Graph g) {
    ids = new int[g.V()];
    visited = new boolean[g.V()];
    count = 0;

    for (int v = 0; v < g.V(); v++) {
      if (!visited[v]) {
        bfs(g, v);
        count++;
      }
    }
  }

  private void bfs(Graph g, int src) {
    visited[src] = true;
    ids[src] = count;

    Queue<Integer> q = new Queue<>();
    q.enqueue(src);
    while (!q.isEmpty()) {
      int v = q.dequeue();

      for (Integer w : g.adj(v)) {
        if (!visited[w]) {
          visited[w] = true;
          ids[w] = count; // ???
          q.enqueue(w);
        }
      }
    }
  }

  public int id(int v) {
    return ids[v];
  }

  public int count() {
    return this.count;
  }

  public ArrayList<Integer>[] components() {
    ArrayList<Integer>[] comps = new ArrayList[count];
    for (int i = 0; i < comps.length; i++)
      comps[i] = new ArrayList<>();
    for (int i = 0; i < ids.length; i++)
      comps[id(i)].add(i);
    return comps;
  }

  @Override
  public String toString() {
    int M = this.count;
    StringBuilder sbuilder = new StringBuilder("" + M + " components\n");
    ArrayList<Integer>[] components;

    components = (ArrayList<Integer>[]) new ArrayList[M];
    for (int i = 0; i < M; i++)
      components[i] = new ArrayList<Integer>();

    for (int v = 0; v < ids.length; v++)
      components[this.id(v)].add(v);

    int this_row_id = -1;
    for (int i = 0; i < M; i++) {
      this_row_id = id(components[i].get(0));
      sbuilder.append("" + this_row_id + "': ");
      for (int v : components[i])
        sbuilder.append("" + v + " ");
      sbuilder.append("\n");
    }

    return sbuilder.toString();
  }

  public static void main(String[] args) {
    Graph g = new Graph(new In("algs4-data/tinyG.txt"));
    CCBfs cc = new CCBfs(g);
    int M = cc.count();

    StdOut.println(M + " components");
    Bag<Integer>[] components;

    components = (Bag<Integer>[]) new Bag[M];
    for (int i = 0; i < M; i++)
      components[i] = new Bag<Integer>();

    for (int v = 0; v < g.V(); v++)
      components[cc.id(v)].add(v);

    for (int i = 0; i < M; i++) {
      for (int v : components[i])
        StdOut.print(v + " ");
      StdOut.println();
    }
  }
}
