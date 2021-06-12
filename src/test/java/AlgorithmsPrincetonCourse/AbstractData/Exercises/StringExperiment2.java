package AlgorithmsPrincetonCourse.AbstractData.Exercises;


/**
 * exercise-2.4.5
 * 
 * Imprime "hello world". Os métodos chamados na string
 * não modificam a string in-place. String são imutáveis.
 */
public class StringExperiment2 {
  public static void main(String[] args) {
    String s = "hello world";
    s.toUpperCase();
    s.substring(6, 11);
    System.out.println(s);
  }
}
