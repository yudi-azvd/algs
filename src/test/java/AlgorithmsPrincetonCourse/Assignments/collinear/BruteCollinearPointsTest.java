package AlgorithmsPrincetonCourse.Assignments.collinear;

import org.junit.Test;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

public class BruteCollinearPointsTest {
  @Test
  public void someTest() {
    In in = new In("collinear/rs1423.txt");

    int n = in.readInt();
    Point[] points = new Point[n];
    for (int i = 0; i < n; i++) {
        int x = in.readInt();
        int y = in.readInt();
        points[i] = new Point(x, y);
    }

    // draw the points
    // StdDraw.enableDoubleBuffering();
    StdDraw.setXscale(0, 32768);
    StdDraw.setYscale(0, 32768);
    for (Point p : points) {
      p.draw();
    }
      
    System.out.println("oi");
    // StdDraw.show();

    assert true;
  }  
}
