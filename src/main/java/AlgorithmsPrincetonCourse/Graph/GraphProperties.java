package AlgorithmsPrincetonCourse.Graph;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;

public class GraphProperties {
  private int[] eccentricities;
  private int radius;
  private int diameter;
  private int center;
  
  // O(V * (V + E))
  public GraphProperties(Graph g) {
    // discaradamente copiado daqui
    // https://github.com/reneargento/algorithms-sedgewick-wayne/blob/3228554761158f488c480743cd3e1ad43d3f1481/src/chapter4/section1/GraphProperties.java#L42
    diameter = 0;
    radius = Integer.MAX_VALUE;
    center = 0;
    eccentricities = new int[g.V()];

    for (int vertex = 0; vertex < g.V(); vertex++) {
      BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(g, vertex);

      for (int otherVertex = 0; otherVertex < g.V(); otherVertex++) {
        if (otherVertex == vertex) {
          continue;
        }

        eccentricities[vertex] = Math.max(eccentricities[vertex],
            breadthFirstPaths.distTo(otherVertex));
      }

      if (eccentricities[vertex] > diameter) {
        diameter = eccentricities[vertex];
      }
      if (eccentricities[vertex] < radius) {
        radius = eccentricities[vertex];
        center = vertex;
      }
    }
  }

  public int radius() {
    return radius;
  }

  public int diameter() {
    return diameter;
  }

  public int center() {
    return center;
  }

  public int eccentricity(int v) {
    return eccentricities[v];
  }

  @Override
  public String toString() {
    String result = "";
    result += "Props:\n";
    result += "diameter: " + diameter + "\n";
    result += "  radius: " + radius + "\n";
    result += "  center: " + center + "\n";

    result += "   eccs: " + eccentricities.toString() + "\n";

    return result;
  }
}
