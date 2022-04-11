package AlgorithmsPrincetonCourse.chap04.undirgraph.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

public class _4_1_36_BridgeNaiveTest {
  private _4_1_36_BridgeNaive bridgeChecker;
  private Graph g;
  private In in;

  @Test
  public void testTinyCG() {
    in = new In("algs4-data/tinyCG.txt");
    g = new Graph(in);
    bridgeChecker = new _4_1_36_BridgeNaive(g);

    assertEquals(false, bridgeChecker.hasBridge());
  }  

  @Test
  public void testTinyG() {
    in = new In("algs4-data/tinyG.txt");
    g = new Graph(in);
    bridgeChecker = new _4_1_36_BridgeNaive(g);

    assertEquals(true, bridgeChecker.hasBridge());
  }  
}
