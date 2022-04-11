package AlgorithmsPrincetonCourse.chap01.sec1_3.linkedlist;

public class RandomString {
  private static final String pool = "abcdefghijklmnopqrstuvxwz";

  private static int randomInt(int max) {
    double d = Math.random()*max;
    int i = (int) d;
    return i;
  }

  public static String generate(int n) {
    String result = "";
    int poolLength = pool.length();

    for (int i = 0; i < n; i++) {
      result += pool.charAt(randomInt(poolLength)) + " ";
    }

    return result;
  }
}