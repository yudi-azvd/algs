package AlgorithmsPrincetonCourse.Queue;

import edu.princeton.cs.algs4.Queue;

public class Josephus {
  public static Queue<Person> josephus(int n, int m) {
    Queue<Person> circle = new Queue<>();
    Queue<Person> eliminatedPeople = new Queue<>();

    for (int i = 0; i < n; i++) {
      circle.enqueue(new Person(i));
    }

    int mCounter = 1;
    while (eliminatedPeople.size() != n) {
      for (Person person : circle) {
        if (!person.isEliminated() && (mCounter == m)) {
          if (mCounter == m) {
            person.eliminate();
            eliminatedPeople.enqueue(person);
            mCounter = 1;
          }
        }
        else {
          mCounter++;
        }
      }
    }

    return eliminatedPeople;
  }

  public static void main(String[] args) {
    System.out.println(josephus(9, 3));
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