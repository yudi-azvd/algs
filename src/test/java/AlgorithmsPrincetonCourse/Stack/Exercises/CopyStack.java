package AlgorithmsPrincetonCourse.Stack.Exercises;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import edu.princeton.cs.algs4.Stack;

public class CopyStack {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    
    
    for (int i = 0; i < 10; i++) {
      stack.push(Integer.toString(i));
    }
    
    Stack<String> copy = copyOf(stack);

    assertTrue("stack should be copied correctly", areEqual(copy, stack));
  }

  public static boolean areEqual(Stack<String> s1, Stack<String> s2) {
    if (s1.size() != s2.size())
      return false;
    
    Iterator<String> it1 = s1.iterator();
    Iterator<String> it2 = s2.iterator();

    while (it1.hasNext() && it2.hasNext())
      if (it1.next() != it2.next())
        return false;

    return true;
  }
  
  public static Stack<String> copyOf(Stack<String> source) {
    Stack<String> copy = new Stack<>();
    Stack<String> secondCopy = new Stack<>();

    for (String item : source) {
      copy.push(item);
    }

    for (String item : copy) {
      secondCopy.push(item);
    }

    return secondCopy;
  }
}