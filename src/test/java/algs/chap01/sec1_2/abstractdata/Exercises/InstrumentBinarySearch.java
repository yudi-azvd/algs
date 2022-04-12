package algs.chap01.sec1_2.abstractdata.Exercises;

import java.util.Arrays;
import algs.chap01.sec1_2.abstractdata.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


/**
 * <code>exercise-1.2.9</code>
 */
@SuppressWarnings("deprecation")
public class InstrumentBinarySearch {
  public static int rank(int key, int[] a, Counter counter) { // Array must be sorted.
    int lo = 0;
    int hi = a.length - 1;

    while (lo <= hi) { 
      counter.increment();
      // Key is in a[lo..hi] or not present.
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) 
        hi = mid - 1;
      else if (key > a[mid]) 
        lo = mid + 1;
      else return mid;
    }
    return -1;
  }

  public static void main(String[] args){
    Counter counter = new Counter("key examinations");
    int[] whitelist = In.readInts("algs4-data/tinyW.txt");
    In input = new In("algs4-data/tinyT.txt");
    Arrays.sort(whitelist);

    while (!input.isEmpty()) {
      // Read key, print if not in whitelist.
      int key = input.readInt();
      if (rank(key, whitelist, counter) < 0)
      StdOut.println(key);
    }

    System.out.println(counter);
  }
}