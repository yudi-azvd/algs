package algs.assignments.collinear;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
  private int segments;
  private final ArrayList<LineSegment> lineSegments;
  private final Point[] points;

  public FastCollinearPoints(Point[] pts) {
    if (pts == null)
      throw new IllegalArgumentException("Points array must not be null");
    
    for (Point p : pts)
      if (p == null) 
        throw new IllegalArgumentException("Points array must not contain null point");
    
    Arrays.sort(pts);
    for (int i = 1; i < pts.length; i++)
      if (pts[i].compareTo(pts[i-1]) == 0)
        throw new IllegalArgumentException("There are duplicate points");

    segments = 0;
    points = Arrays.copyOf(pts, pts.length);
    lineSegments = new ArrayList<>();
    findSegments();
  }
 
  private void findSegments() {
    Point p;
    Point[] ptsInLine = new Point[4];
    LineSegment line;

    for (int i = 0; i < points.length; i++) {
      p = points[i];

      // não deveria ser ordenado um vetor sem p?
      Arrays.sort(points, p.slopeOrder());

      for (int j = 0; j < points.length-2; j++) {
        double pj0slope = p.slopeTo(points[j]);
        double pj1slope = p.slopeTo(points[j+1]);
        double pj2slope = p.slopeTo(points[j+2]);

        if (pj0slope == pj1slope && pj1slope == pj2slope) {
          ptsInLine[0] = p;
          ptsInLine[1] = points[j+0];
          ptsInLine[2] = points[j+1];
          ptsInLine[3] = points[j+2];
  
          Arrays.sort(ptsInLine);
          line = new LineSegment(ptsInLine[0], ptsInLine[3]);
          lineSegments.add(line);
        }
      }
    }

    segments = lineSegments.size();
  }

  public int numberOfSegments() {
    return segments;
  }

  public LineSegment[] segments() {
    LineSegment[] arr = new LineSegment[lineSegments.size()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = lineSegments.get(i);
    }
    return arr;
  }
}
