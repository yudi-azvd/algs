package AlgorithmsPrincetonCourse.chap01.sec1_2.AbstractData.Exercises;

import java.util.ArrayList;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdDraw;


/**
 * <code>exercise-1.2.2</code>
 */
public class Intersecting1DIntervals {
  static int limit;
  static Interval1D[] intervals;

  static In in;

  public static void readIntervals() {
    ArrayList<Interval1D> inters = new ArrayList<>();
    int a, b;

    while(!in.isEmpty()) {
      a = in.readInt();
      b = in.readInt();

      if (a == b)
        continue;

      if (a < b)
        inters.add(new Interval1D(a, b));
      else
        inters.add(new Interval1D(b, a));
    }

    int i = 0;
    intervals = new Interval1D[inters.size()];
    for (Interval1D interval : inters) {
      intervals[i++] = interval;
    }
  }

  public static boolean intervalsIntersect(Interval1D a, Interval1D b) {
    if (a.max() > b.min()) return true;
    if (a.min() < b.max()) return true;
    return false;
  }

  public static void drawIntervals() {
    StdDraw.setYscale(-1, intervals.length+1);
    for (int y = 0; y < intervals.length; y++) {
      StdDraw.line(intervals[y].min(), y, intervals[y].max(), y);
    }
  }


  public static void detectIntervals() {
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.setPenRadius(0.01);
    for (int i = 0; i < intervals.length; i++) {
      for (int j = i+1; j < intervals.length; j++) {
        if (intervalsIntersect(intervals[i], intervals[j])) {
          StdDraw.point(intervals[i].max(), i);
          StdDraw.point(intervals[j].min(), i);
          StdDraw.point(intervals[j].max(), i);
          StdDraw.point(intervals[i].min(), i);
          // if (intervals[i].max() > intervals[j].min()) {
          //   StdDraw.line(intervals[j].min(), i, intervals[i].max(), i);
          // }
          // else {
          //   StdDraw.line(intervals[i].min(), i, intervals[j].max(), i);
          // }
        }
      }
    }
  }
  
  public static void main(String[] args) {
    in = new In("percolation/input3.txt");
    limit = in.readInt();
    
    StdDraw.setYscale(-1, limit+1);
    StdDraw.setXscale(-1, limit+1);
    StdDraw.show();
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.setPenRadius(0.005);

    readIntervals();
    drawIntervals();
    // detectIntervals();
    // System.out.println(
    //   Arrays.toString(intervals)
    // );

    System.out.println("\nend");
  }
}
