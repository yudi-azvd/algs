// package AlgorithmsPrincetonCourse.Queue;

// import java.io.File;

// public class ListingFiles {
//   public static void printDirectory(String dirName) {
//     File file = new File(dirName);
//     System.out.println("file: " + file.getName());

//     File[] filesInDirName = file.listFiles();

//     System.out.println("filesInDirName: " + filesInDirName);
    
//     for (File fileInDirName : filesInDirName) {
//       String name = fileInDirName.getName();
//       System.out.println(name);
//       // printDirectory(fileInDirName.getName());
//       // System.out.println(fileInDirName.getAbsolutePath());
//       File[] subFiles = fileInDirName.listFiles();
      
//       for (File subFile : subFiles) {
//         System.out.println("  " + subFile.getName());
        
//         if (subFile.isFile()) {
//           continue;
//         }

//         File[] subSubFiles = subFile.listFiles();
//         for (File subSubFile : subSubFiles) {
//           System.out.println("    " + subSubFile.getName());
//         }
//       }
//     }
//   }

//   public static void main(String[] args) {
//     // File file = new File("src/test/java/AlgorithmsPrincetonCourse");

//     // printDirectory("src/");
//     printDirectory("src/test/java/AlgorithmsPrincetonCourse");

//     // System.out.println("file " + file);
//     // System.out.println(file.getAbsolutePath());
//     // System.out.println(file.isDirectory());
//     // System.out.println(file.list());

//     // for (File fileItem : file.listFiles()) {
//     //   System.out.println(fileItem);
//     // }

//     // for (String str : file.list()) {
//     //   File testFile = new File(str);

//     //   String result = "";

//     //   if (testFile.isDirectory()) {
//     //     result += "directory ";
//     //   }
//     //   else if (testFile.isFile()) {
//     //     result += "     file ";
//     //   }

//     //   result += testFile.getName();

//     //   System.out.println(result);
//     // }
//   }
// }