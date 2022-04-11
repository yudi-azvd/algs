package AlgorithmsPrincetonCourse.chap01.sec1_3.exercises;

import static org.junit.Assert.assertTrue;
import AlgorithmsPrincetonCourse.chap01.sec1_3.stack.Stack;

/**
 * Algorithms 4a ed.
 * creative-problems: 1.3.42
 */
public class CopyStack {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    
    
    for (int i = 0; i < 10; i++) {
      stack.push(Integer.toString(i));
    }
    
    Stack<String> copy = new Stack<>(stack);

    assertTrue("stack should be copied correctly", copy.isCopyOf(stack));
  }
}