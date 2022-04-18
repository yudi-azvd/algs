package algs.ch4.sec4_1_undirgraph;

import java.util.ArrayList;
import java.util.Arrays;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * Versão iterativa de DFSSearch
 */
public class iDFSSearch {
  private int[] visited;
  private int visit_counter;
  private final int NOT_VISITED = -1;
  private ArrayList<Queue<Integer>> queues;

  public iDFSSearch(Graph g, int src) {
    visited = new int[g.V()];
    initQueues(g);
    Arrays.fill(visited, -1);
    dfs_i(g, src);
  }

  private void dfs_i(Graph g, int src) {
    Stack<Queue<Integer>> stack = new Stack<>();
    int v = src, w;
    stack.push(queues.get(v));
    visited[v] = visit_counter++;
    Queue<Integer> adjToV = queues.get(v);

    while (!stack.isEmpty()) {
      adjToV = stack.peek();
      if (!adjToV.isEmpty()) {
        w = adjToV.dequeue();

        if (visited[w] == NOT_VISITED) {
          visited[w] = visit_counter++;
          stack.push(queues.get(w));
        }
      } else {
        stack.pop();
      }
    }
  }

  public int count() {
    return visit_counter;
  }

  public int[] visitationOrder() {
    return visited.clone();
  }

  private void initQueues(Graph g) {
    queues = new ArrayList<>(g.V());
    for (int v = 0; v < g.V(); v++) {
      queues.add(new Queue<>());
      for (int w : g.adj(v)) {
        queues.get(v).enqueue(w);
      }
    }
  }

  public static void main(String[] args) {
    In in = new In("algs4-data/tinyCG.txt");
    Graph g = new Graph(in);
    iDFSSearch search = new iDFSSearch(g, 0);

    System.out.println(Arrays.toString(search.visitationOrder()));
  }
}
