package AlgorithmsPrincetonCourse.Assignments.collinear;

import java.util.Scanner;
// import org.junit.Ignore;
import org.junit.Test;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

// @Ignore
public class BruteCollinearPointsTest {
  @Test
  public void someTest() {
    In in = new In("collinear/input8.txt");
    
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
    
    BruteCollinearPoints collinear = 
    new BruteCollinearPoints(points);
    
    for (LineSegment line : collinear.segments()) {
      // System.out.println(line);
      line.draw();
    }
    StdDraw.show();
    
    // único jeito que consegui fazer pra não fechar 
    // o StdDraw no final do programa.
    Scanner sc = new Scanner(System.in);
    sc.nextLine();
    sc.close();
  }  
}
