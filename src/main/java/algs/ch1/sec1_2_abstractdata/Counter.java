package algs.ch1.sec1_2_abstractdata;

public class Counter {
  private String name;
  private int counter;

  public Counter(String name) {
    this.name = name;
    counter = 0;
  }

  public void increment() {
    ++counter;
  }

  public int tally() {
    return counter;
  }

  @Override
  public String toString() {
    return name + ": " + counter;
  }

  public static void main(String[] args) {
    Counter c1 = new Counter("ones");
    c1.increment();
    Counter c2 = c1;
    c2.increment();
    System.out.println(c1);
  }
}
