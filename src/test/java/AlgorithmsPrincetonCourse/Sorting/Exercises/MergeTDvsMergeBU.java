package AlgorithmsPrincetonCourse.Sorting.Exercises;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * <code>exercise-2.2.6</code>
 * 
 * <p>Merge top-down <i>vs</i> Merge bottom-up em termos de quantidade de acessos
 * ao array. Os dois plots são comparados com o valor 6NlgN.
 * 
 * <p><strong>Ainda tem coisa esquisita</strong>
 */
public class MergeTDvsMergeBU {
  private static int[] generateRandomArrayWithSize(int size) {
    int[] arr = new int[size];
    
    for (int i = 0; i < arr.length; i++) {
      arr[i] = StdRandom.uniform(0, 100);      
    }
    
    return arr;
  }
  
  private static double theoreticalFunction(int n) { 
    // 6 N lg(n), lg(n) = log de n na base 2
    return (6*n*Math.log(n)/Math.log(2));
  }
  
  private static void setupGraphics() {
    StdDraw.show();
    StdDraw.setXscale(0, 600);
    StdDraw.setYscale(0, 30000);
    StdDraw.setPenRadius(0.015);
    
    StdDraw.setPenColor(StdDraw.GRAY);
    StdDraw.point(30, 22000);
    StdDraw.textLeft(40, 22000, "Theoretical upper limit");
    
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.point(30, 21000);
    StdDraw.textLeft(40, 21000, "Mergesort top-down");
    
    StdDraw.setPenColor(StdDraw.BLUE);
    StdDraw.point(30, 20000);
    StdDraw.textLeft(40, 20000, "Mergesort bottom-up");

    StdDraw.setPenRadius(0.010);
  }
  
  private static void plotPoints(
    int size,
    int accesssTD, 
    int accesssBU,
    double accessTheoretical
  ) {
    StdDraw.setPenColor(StdDraw.GRAY);
    StdDraw.point(size, accessTheoretical);
    
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.point(size, accesssTD);
    
    StdDraw.setPenColor(StdDraw.BLUE);
    StdDraw.point(size, accesssBU);
  }
  
  public static void main(String[] args) {
    int accesssBU, accesssTD;
    double accessTheoretical;
    int[] arr;
    final int MAX_SIZE = 512;
    
    setupGraphics();
    
    for (int size = 1; size < MAX_SIZE; size++) {
      arr = generateRandomArrayWithSize(size);
      
      accessTheoretical = theoreticalFunction(size);
      accesssBU = CountMergeBU.sort(arr);
      accesssTD = CountMergeTD.sort(arr);

      plotPoints(size, accesssTD, accesssBU, accessTheoretical);
    }

    StdDraw.save("./.github/compare-merge-td-vs-bu.png");
  }
}
