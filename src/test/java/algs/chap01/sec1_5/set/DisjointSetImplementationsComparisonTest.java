package algs.chap01.sec1_5.set;
// package AlgorithmsPrincetonCourse.DisjointSet;

// import java.io.InputStream;
// import java.util.Scanner;

// import org.junit.Test;

// 
// 
// /**
//  * QuickFind
//  * QuickUnion
//  * WeigthedQuickUnion
//  * WeigthedQuickUnionWithCompression
//  */
// public class DisjointSetImplementationsComparisonTest {
//   private String[] filenames = {
//     "algs4-data/tinyUF.txt",
//     "algs4-data/mediumUF.txt"//,
//     // "algs4-data/largeUF.txt"
//   };

//   private InputStream getInputFrom(String filename) {
//     return getClass().getClassLoader().getResourceAsStream(filename);
//   }

//   private void executeTask(Scanner scanner, DisjointSet set, Class DisjointSetType) {
//     int size = scanner.nextInt();
//     // set = new DisjointSetType(size);
//     // set = DisjointSetType.newInstance();

//     while (scanner.hasNextInt()) {
//       int p = scanner.nextInt();
//       int q = scanner.nextInt();

//       if (set.connected(p, q))
//         continue;
      
//       set.union(p, q);
//     }    
//   }

//   @Test
//   public void compare_implementations() {
//     DisjointSet set;

//     // set = new QuickFindDisjointSet(size);
//     // QuickFindDisjointSet QFSet = new QuickFindDisjointSet()
//   }
// }