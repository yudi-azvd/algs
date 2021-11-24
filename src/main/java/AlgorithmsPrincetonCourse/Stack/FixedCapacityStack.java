package AlgorithmsPrincetonCourse.Stack;

@SuppressWarnings("unchecked")
public class FixedCapacityStack<Item> implements IStack<Item> {
  private int size = 0;
  private int capacity = 1;
  private Item[] stack = (Item[]) new Object[capacity];

  public void push(Item item) {
    if (size == capacity) {
      capacity *= 2;
      resize(capacity*2);
    }

    stack[size++] = item;
  }

  private void resize(int newCapacity) {
    Item[] copy = (Item[]) new Object[newCapacity];

    for (int i = 0; i < size; i++) {
      copy[i] = stack[i];
    }

    stack = copy;
  }

  public Item pop() {
    Item item = stack[--size];
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