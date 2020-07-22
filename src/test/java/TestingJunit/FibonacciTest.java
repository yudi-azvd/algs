package TestingJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FibonacciTest {
  @Parameters(name= "{index}: fib[{0}]={1}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(
      new Object[][] {
        { 0, 0 }, 
        { 1, 1 },
        { 2, 1 },
        { 3, 2 },
        { 4, 3 },
        { 5, 5 },
        { 6, 8 } 
      });
  }
  
  private int fInput;
  
  private int fExpected;
  
  public FibonacciTest(int input, int expected) {
    fInput= input;
    fExpected= expected;
  }
  
  @Test
  public void test() {
    assertEquals(fExpected, Fibonacci.compute(fInput));
  }

  static class Fibonacci {
    public static int compute(int n) {
      if (n == 0) {
        return 0;
      }
      else if (n == 1) {
        return 1;
      }
      else 
        return compute(n-1) + compute(n-2);
    }
  }
}