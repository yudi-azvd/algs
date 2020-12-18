// package AlgorithmsPrincetonCourse.Sorting;

// import java.io.File;
// import java.io.InputStream;

// import edu.princeton.cs.algs4.In;
// import edu.princeton.cs.algs4.StdOut;

// @SuppressWarnings("unchecked")
// public class Example {
//   public static void sort(Comparable[] a) {
//     StdOut.println("sorteado");
//   }

//   private static boolean less(Comparable v, Comparable w) {
//     return v.compareTo(w) < 0;  
//   }

//   private static void exch(Comparable[] a, int i, int j) {
//     Comparable tmp = a[i];
//     a[i] = a[j];
//     a[j] = tmp;
//   }

//   private static void show(Comparable[] a) {
//     for (int i = 1; i < a.length; i++)
//       StdOut.print(a[i] + " ");
//     StdOut.println();
//   }
  
//   private static boolean isSorted(Comparable[] a) {
//     for (int i = 1; i < a.length; i++)
//       if (less(a[i], a[i-1]))
//         return false;
//     return true;
//   }

//   public static void main(String[] args) {
//     StdOut.print("---hey 1");

//     String[] a = In.readStrings();
    
//     sort(a);
//     assert isSorted(a);

//     StdOut.print("---hey 2");
//   }
// }
