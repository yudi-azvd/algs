package AlgorithmsPrincetonCourse.Assignments.collinear;

import java.util.ArrayList;
import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

public class BruteCollinearPoints {
  private Point[] points;
  private ArrayList<LineSegment> lineSegments;

  public BruteCollinearPoints(Point[] pts) {
    if (pts == null)
      throw new IllegalArgumentException("Points array must not be null");
    
    for (Point p : pts)
      if (p == null) 
        throw new IllegalArgumentException("Points array must not contain null point");

    // deveria ser verificada também a existência de pontos duplicados
    // 1. ordenar e checar se há um ponto igual na sequência.
    // 2. usar hashtable, mas ahco que ainda não pode.

    points = pts;
    lineSegments = new ArrayList<>();
    // int segmentsCounter = numberOfSegments();
    numberOfSegments();
  }  

  public int numberOfSegments() { 
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

            System.out.print("checking points " + p + q + r + s + '\n');

            pqSlope = p.slopeTo(q);
            prSlope = p.slopeTo(r);
            psSlope = p.slopeTo(s);

            if (pqSlope == prSlope && pqSlope == psSlope) {
              pts[0] = p;
              pts[1] = q;
              pts[2] = r;
              pts[3] = s;
              System.out.print("ARE collinear ");
    
              // TODO: existe algum jeito mais natural de 
              // ordenar esse array?
              Arrays.sort(pts, Point.BY_Y);
              Arrays.sort(pts, Point.BY_X);
              LineSegment line = new LineSegment(pts[0], pts[3]);
              System.out.println(Arrays.toString(pts));
              System.out.println(line);
              System.out.println();
              lineSegments.add(line);
              segmentsCounter++;
            }
            else {
              // System.out.println("NOT collinear\n");
            }
          }
        }
      }
    }

    return segmentsCounter; 
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
    In in = new In("collinear/input50.txt");

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
