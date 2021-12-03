package AlgorithmsPrincetonCourse.Assignments.collinear;

import java.util.Scanner;
import org.junit.Ignore;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

@Ignore("What the hell?")
public class FastCollinearPointsTest {
  @Ignore
  public void someAnotherTest() {
    // read the n points from a file
    String filename = "collinear/input40.txt";
    In in = new In(filename);

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

    FastCollinearPoints collinear = new FastCollinearPoints(points);
    for (LineSegment segment : collinear.segments()) {
      segment.draw();
    }
    StdDraw.show();

    System.out.println("segs:" + collinear.numberOfSegments());
    Scanner sc = new Scanner(System.in);
    sc.nextLine();
    sc.close();
  }
}
