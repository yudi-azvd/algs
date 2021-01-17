package AlgorithmsPrincetonCourse.Assignments.collinear;

import java.util.Scanner;
import org.junit.jupiter.api.Test;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPointsTest {
  @Test
  public void someAnotherTest() {
    // read the n points from a file
    In in = new In("collinear/rs1423.txt");

    int n = in.readInt();
    Point[] points = new Point[n];
    for (int i = 0; i < n; i++) {
      int x = in.readInt();
      int y = in.readInt();
      points[i] = new Point(x, y);
    }
    
    // draw the points
    StdDraw.enableDoubleBuffering();
    StdDraw.setXscale(0, 32768);
    StdDraw.setYscale(0, 32768);
    for (Point p : points) {
      p.draw();
    }
    StdDraw.show();
    
    // print and draw the line segments
    FastCollinearPoints collinear = new FastCollinearPoints(points);
    for (LineSegment segment : collinear.segments()) {
      // StdOut.println(segment);
      segment.draw();
    }

    StdDraw.show();
    Scanner sc = new Scanner(System.in);
    sc.nextLine();
    sc.close();
  }
}
