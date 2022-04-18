package algs.ch1.sec1_2_abstractdata.exercises;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * <code>exercise-1.2.1</code>
 */
public class ClosestPairOfPoints {
  static int N;
  static Point2D points[];
  static Point2D minPointA;
  static Point2D minPointB;
  static double[] distances;
  
  public static void generatePoints() throws InterruptedException {
    points = new Point2D[N];
    double x, y;
    for (int i = 0; i < points.length; i++) {
      x = StdRandom.uniform(0, 100);
      TimeUnit.MILLISECONDS.sleep(500);
      y = StdRandom.uniform(0, 100);
      points[i] = new Point2D(x, y);
    }
  }

  public static void calculateDistances() {
    distances = new double[N*(N-1)/2];
    int distIndex = 0;
    double currentMinDistance = Double.POSITIVE_INFINITY,
       newDistance = 0;
    boolean newDistanceIsSmaller = false;
    
    for (int i = 0; i < points.length; i++) {
      for (int j = i+1; j < points.length; j++) {
        points[i].draw();
        points[j].draw();
        newDistance = points[i].distanceTo(points[j]);
        distances[distIndex] = newDistance;
        
        // System.out.println(points[i]);
        
        newDistanceIsSmaller = newDistance < currentMinDistance;
        if (newDistanceIsSmaller) {
          currentMinDistance = newDistance;
          minPointA = points[i];          
          minPointB = points[j];          
        } 
      }
    }
    Arrays.sort(distances);
  }

  public static void drawShortestDistance() {
    StdDraw.setPenColor(StdDraw.BLUE);
    StdDraw.line(minPointA.x(), minPointA.y(), 
      minPointB.x(), minPointB.y());
    minPointA.draw();
    minPointB.draw();

    // System.out.println("min dist: " + minPointA.distanceTo(minPointB));
  }
  
  public static void main(String[] args) throws InterruptedException {
    N = 50;
    StdDraw.show();
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.setXscale(-0.2, 101);
    StdDraw.setYscale(-0.2, 101);
    StdDraw.setPenRadius(.005);
    // StdRandom.setSeed(30);

    generatePoints();
    calculateDistances();

    drawShortestDistance();


    // System.out.println();
    // System.out.println("end");
  }
}
