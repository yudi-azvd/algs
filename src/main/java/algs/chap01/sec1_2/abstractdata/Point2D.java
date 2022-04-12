package algs.chap01.sec1_2.abstractdata;

import edu.princeton.cs.algs4.StdDraw;

public class Point2D {
  private double x;
  private double y;

  Point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public double x() {
    return x;
  }

  public double y() {
    return y;
  }

  public double distTo(Point2D that) {
    return Math.sqrt( x*x + y*y);
  }

  public void draw() {
    StdDraw.point(x, y);
  }
}
