package AlgorithmsPrincetonCourse.chap01.sec1_3.stack;

public class ResizingArrayStackOfStrings implements IStackOfStrings {
  private int size = 0;
  private int capacity = 1;
  private String[] stack = new String[capacity];

  public void push(String item) {
    if (size == capacity) {
      // String[] tmp = new String[capacity];
      // System.arraycopy(stack, 0, tmp, 0, capacity);
      // stack = new String[capacity*2];
      // System.arraycopy(tmp, 0, stack, 0, capacity);
      capacity *= 2;
      resize(capacity*2);
    }

    stack[size++] = item;
  }

  private void resize(int newCapacity) {
    String[] copy = new String[newCapacity];

    for (int i = 0; i < size; i++) {
      copy[i] = stack[i];
    }

    stack = copy;
  }

  public String pop() {
    String item = stack[--size];
    stack[size] = null;

    if (size > 0 && size == capacity/4) {
      resize(capacity/2);
    }

    return item;
  }

  public boolean isEmpty() {
    return size == 0;
  }
}