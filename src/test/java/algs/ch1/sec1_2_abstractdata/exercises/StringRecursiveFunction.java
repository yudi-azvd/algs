package algs.ch1.sec1_2_abstractdata.exercises;


/**
 * exercise-2.4.7
 * 
 * Reverte a string.
 */
public class StringRecursiveFunction {
  public static String mystery(String s) {
    int N = s.length();
    if (N <= 1) return s;

    String a = s.substring(0, N/2);
    String b = s.substring(N/2, N);
    return mystery(b) + mystery(a);
  }

  public static void main(String[] args) {
    System.out.println(mystery("1234")); // 4321
    System.out.println(mystery("12345678"));
    System.out.println(mystery("abcdef"));
  }
}
