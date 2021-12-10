package AlgorithmsPrincetonCourse.Graph.Exercises;

import java.util.ArrayList;
import AlgorithmsPrincetonCourse.Graph.CCBfs;
// import AlgorithmsPrincetonCourse.Graph.GraphProperties;
import AlgorithmsPrincetonCourse.Graph.MySymbolGraph;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.ST;

/**
 * <code>exercise-4.1.24</code> connected components in movies.txt
 */
public class _4_1_24_CCMovies {
  static private MySymbolGraph sg;
  static private CCBfs cc;

  public static void main(String[] args) {
    String filename = "algs4-data/movies.txt";
    String delim = "/";
    // String filename = "algs4-data/routes.txt";
    // String delim = " ";

    sg = new MySymbolGraph(filename, delim);
    Graph g = sg.graph();

    cc = new CCBfs(g);
    ArrayList<Integer>[] components = cc.components();
    // System.out.println(cc);

    System.out.printf("                        components: %d\n", cc.count());
    System.out.printf(" number of components of size < 10: %d\n",
        findNumberOfComponentsOfSizeLessThan10(components));
    ArrayList<Integer> largestComponent = findLargestComponent(components);
    System.out.printf("            largest component size: %d (id: %d)\n",
        largestComponent.size(), cc.id(largestComponent.get(0)));

    // Graph subgraph = getSubgraphLargestComponent(largestComponent, g);
    // System.out.println(subgraph);
    System.out.printf(" largest component has Kevin Bacon: %b\n", doesComponentHaveKevinBacon(sg, largestComponent));
    // Propriedades demora muito. Dá uma olhada como esse cara resolveu
    // https://github.com/reneargento/algorithms-sedgewick-wayne/blob/master/src/chapter4/section1/Exercise24.txt
    // GraphProperties props = new GraphProperties(subgraph);
    // System.out.printf("           largest component props: %s\n", props);
  }

  private static ArrayList<Integer> findLargestComponent(
      ArrayList<Integer>[] components) {
    int largestSize = 0;
    ArrayList<Integer> largest = null;
    for (ArrayList<Integer> c : components) {
      if (c.size() > largestSize) {
        largestSize = c.size();
        largest = c;
      }
    }

    return largest;
  }

  private static int findNumberOfComponentsOfSizeLessThan10(
      ArrayList<Integer>[] components) {
    int componentsOfSizeLessThan10 = 0;
    for (ArrayList<Integer> c : components)
      if (c.size() < 10)
        componentsOfSizeLessThan10++;
    return componentsOfSizeLessThan10;
  }

  private static boolean doesComponentHaveKevinBacon(MySymbolGraph sg,
      ArrayList<Integer> component) {
    for (int v : component) {
      String name = sg.name(v);
      if (name.equals("Bacon, Kevin"))
        return true;
    }
    return false;
  }

  @SuppressWarnings("unchecked")
  public static Graph getSubgraphLargestComponent(ArrayList<Integer> component,
      Graph original) {
    Graph subgraph = new Graph(component.size());
    ST<Integer, Boolean>[] maps = new ST[original.V()];

    // Vértices no original não cabem no subgrafo
    // Mapeia os vértices de component para vértices [0, original.V()-1]
    ST<Integer, Integer> originalToSubgraphVertex = new ST<>();

    for (int i = 0; i < maps.length; i++) {
      maps[i] = new ST<>();
    }

    for (int vertex : component)
      originalToSubgraphVertex.put(vertex, originalToSubgraphVertex.size());

    for (int vertex : component) {
      int v = originalToSubgraphVertex.get(vertex);
      for (int w : original.adj(vertex)) {
        int t = originalToSubgraphVertex.get(w);
        if (!maps[v].contains(t) || !maps[t].contains(v)) {
          subgraph.addEdge(v, t);
          maps[v].put(t, true);
          maps[t].put(v, true);
        }
      }
    }

    return subgraph;
  }
}
