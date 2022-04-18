package algs.ch1.sec1_3_collections.queue;

import edu.princeton.cs.algs4.Queue;

/**
 * Algorithms 4a ed.
 * creative-problem-1.3.37
 * 
 * Minha solução não segue o comando da questão à risca.
 * N e M são fornecidos no próprio programa em vez de na
 * linha de comando.
 * 
 * Além disso, não consegui ainda bolar um jeito de testar
 * programaticamente se a solução está correta.
 */
public class Josephus {
  public static Queue<Person> josephus(int n, int m) {
    Queue<Person> circle = new Queue<>();
    Queue<Person> eliminatedPeople = new Queue<>();

    fillWithPeople(circle, n);
    
    int mCounter = 1;
    while (eliminatedPeople.size() != n) {
      for (Person person : circle) {
        if (!person.isEliminated() && mCounter == m) {
          person.eliminate();
          eliminatedPeople.enqueue(person);
          mCounter = 1;
        }

        if (!person.isEliminated())
          mCounter++;
      }
    }

    return eliminatedPeople;
  }

  // public static Queue<Integer> josephus2(int n, int m) {
  // }

  public static void main(String[] args) {
    System.out.println(josephus(9, 3));
  }

  public static void fillWithPeople(Queue<Person> q, int n) {
    for (int i = 0; i < n; i++) {
      q.enqueue(new Person(i));
    }
  }

  public static void fillWithInts(Queue<Integer> q, int n) {
    for (int i = 0; i < n; i++) {
      q.enqueue(i);
    }
  }

  public static class Person {
    private int id;
    private boolean isEliminated;

    Person(int id) {
      this.id = id;
      isEliminated = false;
    }

    public int id() {
      return id;
    }

    public boolean isEliminated() {
      return isEliminated;
    }

    public void eliminate() {
      isEliminated = true;
    }

    public String toString() {
      return "" + id;
    }
  }
}