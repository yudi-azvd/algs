package AlgorithmsPrincetonCourse.chap04.undirgraph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import AlgorithmsPrincetonCourse.chap04.undirgraph.iDFSSearch;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

public class TestiDFSSearch {
  private Graph g;
  private In in;
  private iDFSSearch search;

  @Test
  public void testTinyCG() {
    in = new In("algs4-data/tinyCG.txt");
    g = new Graph(in);
    search = new iDFSSearch(g, 0);

    int[] visited = search.visitationOrder();

    assertEquals(0, visited[0]);
    assertEquals(1, visited[2]);
    assertEquals(2, visited[1]);
    assertEquals(3, visited[3]);
    assertEquals(4, visited[5]);
    assertEquals(5, visited[4]);
  }

  @Test
  public void testTinyG1stCluster() {
    in = new In("algs4-data/tinyG.txt");
    g = new Graph(in);
    search = new iDFSSearch(g, 0);

    int[] visited = search.visitationOrder();

    assertEquals(0, visited[0]);
    assertEquals(1, visited[6]);
    assertEquals(2, visited[4]);
    assertEquals(3, visited[5]);
    assertEquals(4, visited[3]);
    assertEquals(5, visited[2]);
  }

  @Test
  public void testTinyG2ndCluster() {
    in = new In("algs4-data/tinyG.txt");
    g = new Graph(in);
    search = new iDFSSearch(g, 7);

    int[] visited = search.visitationOrder();

    assertEquals(0, visited[7]);
    assertEquals(1, visited[8]);
  }

  @Test
  public void testTinyG3rdCluster() {
    in = new In("algs4-data/tinyG.txt");
    g = new Graph(in);
    search = new iDFSSearch(g, 9);

    int[] visited = search.visitationOrder();

    assertEquals(0, visited[9]);
    assertEquals(1, visited[11]);
    assertEquals(2, visited[12]);
    assertEquals(3, visited[10]);
  }
}
