package algs.ch1.sec1_2_abstractdata.exercises;


/**
 * exercise-2.4.4
 * 
 * Imprime "world hello". O truque é pensar pra onde
 * as referências apontam.
 */
public class StringExperiment {
  public static void main(String[] args) {
    String string1 = "hello";
    String string2 = string1;
    string1 = "world";

    System.out.println(string1);
    System.out.println(string2);
  }
}
