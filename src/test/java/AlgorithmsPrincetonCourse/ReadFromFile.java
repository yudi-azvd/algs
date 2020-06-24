package AlgorithmsPrincetonCourse;

// import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

public class ReadFromFile {
  @Test
  public void readFromFile() {
    // File file = new File(
    //   getClass().getClassLoader().getResource("./heart25.txt").getFile()
    // );

    // System.out.println(file);

    InputStream inputStream = getClass()
      .getClassLoader().getResourceAsStream("heart25.txt");
    
    System.out.println(inputStream);

    // Scanner scanner = new Scanner(file);
    Scanner scanner = new Scanner(inputStream);

    while (scanner.hasNextLine()) {
      System.out.println(scanner.nextLine());
    }

    scanner.close();
  }
}