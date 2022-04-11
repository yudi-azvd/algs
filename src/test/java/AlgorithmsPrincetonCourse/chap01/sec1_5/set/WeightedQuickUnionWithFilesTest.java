package AlgorithmsPrincetonCourse.chap01.sec1_5.set;

import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;
import AlgorithmsPrincetonCourse.chap01.sec1_5.set.WeightedQuickUnionDisjointSet;
import edu.princeton.cs.algs4.Stopwatch;


public class WeightedQuickUnionWithFilesTest {
  private InputStream getInputFrom(String filename) {
    return getClass().getClassLoader().getResourceAsStream(filename);
  }

  @Test
  public void tinyUF() {
    InputStream inputStream = getInputFrom("algs4-data/tinyUF.txt");
  
    // Scanner scanner = new Scanner(file);
    Scanner scanner = new Scanner(inputStream);

    int setSize = scanner.nextInt();

    WeightedQuickUnionDisjointSet set = new WeightedQuickUnionDisjointSet(setSize);
    
    Stopwatch timer = new Stopwatch();
    while (scanner.hasNextInt()) {
      int p = scanner.nextInt();
      int q = scanner.nextInt();

      if (set.connected(p, q))
        continue;
      
      set.union(p, q);
      // System.out.println(p + " " + q);
    }
    System.out.println(timer.elapsedTime());
    scanner.close();
  }


  @Test
  public void mediumUF() {
    InputStream inputStream = getInputFrom("algs4-data/mediumUF.txt");
  
    // Scanner scanner = new Scanner(file);
    Scanner scanner = new Scanner(inputStream);

    int setSize = scanner.nextInt();

    WeightedQuickUnionDisjointSet set = new WeightedQuickUnionDisjointSet(setSize);
    
    Stopwatch timer = new Stopwatch();
    while (scanner.hasNextInt()) {
      int p = scanner.nextInt();
      int q = scanner.nextInt();

      if (set.connected(p, q))
        continue;
      
      set.union(p, q);
      // System.out.println(p + " " + q);
    }
    System.out.println(timer.elapsedTime());
    scanner.close();
  }


  @Test
  public void largeUF() {
    InputStream inputStream = getInputFrom("algs4-data/largeUF.txt");
  
    Scanner scanner = new Scanner(inputStream);

    int setSize = scanner.nextInt();

    WeightedQuickUnionDisjointSet set = new WeightedQuickUnionDisjointSet(setSize);

    Stopwatch timer = new Stopwatch();
    while (scanner.hasNextInt()) {
      int p = scanner.nextInt();
      int q = scanner.nextInt();

      if (set.connected(p, q))
        continue;
      
      set.union(p, q);
      // System.out.println(p + " " + q);
    }
    System.out.println(timer.elapsedTime());
    scanner.close();
  }
}