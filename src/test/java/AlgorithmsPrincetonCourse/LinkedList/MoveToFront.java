package AlgorithmsPrincetonCourse.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Algorithms 4a ed.
 * creative-problems: 1.3.40
 * 
 * Considerando apenas caracteres minúsculos
 */
@RunWith(Parameterized.class)
public class MoveToFront {
  public static void main(String[] args) {
    String characters = "a b c d a b";
    LinkedList<String> list = new LinkedList<>();
    Scanner scanner = new Scanner(characters);

    while (scanner.hasNext()) {
      String character = scanner.next();
      list.moveToFront(character);
    }

    System.out.println(list);
    scanner.close();
  }  

  private static String randomCharacters;
  private static LinkedList<String> list;
  private static Scanner scanner;
  private int n;

  @Parameters(name="{index}:{0}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][] {
      { 10 }, { 30 }, { 50 }, { 100 }, { 200 }
    });
  }

  public MoveToFront(int n) {
    this.n = n;
  }

  @Before
  public void setUp() {
    n = 30;
    randomCharacters = RandomString.generate(n);
    scanner = new Scanner(randomCharacters);
    list = new LinkedList<>();
  }
  
  @After
  public void tearDown() {
    scanner.close();
  }

  @Test
  public void thereShouldBeNoDuplicateCharacters() {
    scanner = new Scanner(RandomString.generate(n));
    list = new LinkedList<>();

    HashMap<String, Boolean> hashMap = new HashMap<>();

    while (scanner.hasNext()) {
      String item = scanner.next();

      list.moveToFront(item);
    }

    hashMap = new HashMap<>();

    for (String item : list) {
      if (!hashMap.containsKey(item)) {
        hashMap.put(item, true);
      }
      else {
        assertFalse(true, "duplicate: " + item);
      }
    }
  }

  @Test
  public void checkOrderWhenDuplicateCharHappens() {
    scanner = new Scanner(RandomString.generate(n));
    list = new LinkedList<>();

    HashMap<String, Boolean> hashMap = new HashMap<>();

    boolean checkPreviousIteration = false;
    String previousItem = null;

    while (scanner.hasNext()) {
      String item = scanner.next();

      list.moveToFront(item);
      
      if (!hashMap.containsKey(item)) {
        hashMap.put(item, true);
      }
      else {
        checkPreviousIteration = true;
        previousItem = item;
      }

      if (checkPreviousIteration) {
        assertEquals(previousItem, list.peekFront());
        checkPreviousIteration = false;
        previousItem = null;
      }
    }
  }

  // @Test
  public void certifyThereAreNoDuplicates() {
    scanner = new Scanner("n f m h m m z t u z e c d i r w x s e c h p i o u i c b t w ");
    list = new LinkedList<>();

    HashMap<String, Boolean> hashMap = new HashMap<>();

    while (scanner.hasNext()) {
      String nextItem = scanner.next();
      list.moveToFront(nextItem);
    }

    for (String item : list) {
      if (!hashMap.containsKey(item)) {
        hashMap.put(item, true);
      }
      else {
        assertFalse(true);
      }
    }
  }
}