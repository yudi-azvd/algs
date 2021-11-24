package AlgorithmsPrincetonCourse.Assignments.collinear;

import java.util.ArrayList;
import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

/**
 * Veja {@link BruteCollinearPointsTest}
 * para executar a classe.
 */
public class BruteCollinearPoints {
  private int segments;
  private Point[] points;
  private ArrayList<LineSegment> lineSegments;

  public BruteCollinearPoints(Point[] pts) {
    if (pts == null)
      throw new IllegalArgumentException("Points array must not be null");
    
    for (Point p : pts)
      if (p == null) 
        throw new IllegalArgumentException("Points array must not contain null point");

    Point[] tmpPts = Arrays.copyOf(pts, pts.length);
    Arrays.sort(tmpPts);
    for (int i = 1; i < tmpPts.length; i++)
      if (tmpPts[i].compareTo(tmpPts[i-1]) == 0)
        throw new IllegalArgumentException("There are duplicate points");

    segments = 0;
    // recomendação do spotbugs em vez de
    // uma atribuição direta
    points = Arrays.copyOf(pts, pts.length);
    lineSegments = new ArrayList<>();
    findSegments();
  }  

  private void findSegments() {
    int segmentsCounter = 0;
    double pqSlope, prSlope, psSlope;
    Point p, q, r, s;
    Point[] pts = new Point[4];

    for (int i = 0; i < points.length; i++) {
      for (int j = i+1; j < points.length; j++) {
        for (int k = j+1; k < points.length; k++) {
          for (int w = k+1; w < points.length; w++) {
            p = points[i];
            q = points[j];
            r = points[k];
            s = points[w];

            // System.out.print("checking points " + p + q + r + s + '\n');

            pqSlope = p.slopeTo(q);
            prSlope = p.slopeTo(r);
            psSlope = p.slopeTo(s);

            if (pqSlope == prSlope && pqSlope == psSlope) {
              pts[0] = p;
              pts[1] = q;
              pts[2] = r;
              pts[3] = s;
              // System.out.print("ARE collinear ");
    
              // Arrays.sort(pts, Point.BY_Y); // não pode 
              // Arrays.sort(pts, Point.BY_X); // não pode
              // Arrays.sort(pts, p.slopeOrder()); // acho que não vai dar certo
              Arrays.sort(pts);
              LineSegment line = new LineSegment(pts[0], pts[3]);
              // System.out.println(Arrays.toString(pts));
              // System.out.println(line);
              // System.out.println();
              lineSegments.add(line);
              segmentsCounter++;
            }
            // else {
            //   // System.out.println("NOT collinear\n");
            // }
          }
        }
      }
    }

    segments = segmentsCounter;
  }

  public int numberOfSegments() { 
    return segments;
  }

  public LineSegment[] segments() {
    int i = 0;
    LineSegment[] arr = new LineSegment[lineSegments.size()];
    for (LineSegment lineSegment : lineSegments) {
      arr[i++] = lineSegment;
    }
    return arr;
  }

  public static void main(String[] args) {
    In in = new In("collinear/input400.txt");

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
        // System.out.println(p);
    }
    StdDraw.show();
    
    BruteCollinearPoints collinear =
      new BruteCollinearPoints(points);
    
    for (LineSegment line : collinear.segments()) {
      // System.out.println(line);
      line.draw();
    }
    StdDraw.show();
  }
}
