package AlgorithmsPrincetonCourse.Assignments.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings("unchecked")
public class RandomizedQueue<Item> implements Iterable<Item> {
  private int capacity, head, tail;
  private Item[] queue;

  // construct an empty randomized queue
  public RandomizedQueue() {
    head = 0;
    tail = 0;
    capacity = 1;
    queue = (Item[]) new Object[capacity];
  }

  // is the randomized queue empty?
  public boolean isEmpty() {
    return head == tail;
  }

  // return the number of items on the randomized queue
  public int size() {
    return tail - head;
  }

    // add the item
  public void enqueue(Item item) {
    validate(item);

    if (tail == capacity-1) {
      resize(capacity*2);
    }

    queue[tail++] = item;
  }

  // remove and return a random item
  public Item dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    int randomPosition = StdRandom.uniform(head, tail);
    
    // swap item at randomPos with item at tail-1
    Item tmp = queue[randomPosition];
    queue[randomPosition] = queue[tail-1];
    queue[tail-1] = tmp;

    Item item = queue[tail-1];
    queue[--tail] = null;

    int size = size();
    if (size > 0 && size == capacity/4) {
      resize(capacity/2); // resizeSmaller
    }

    if (isEmpty()) {
      resize(1); // resizeSmaller
    }

    return item;
  }

  // return a random item (but do not remove it)
  public Item sample() {
    if (isEmpty()) 
      throw new NoSuchElementException();

    int randomPosition = StdRandom.uniform(head, tail);
    return queue[randomPosition];
  }

  private void validate(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
  }

  // resize array queue
  private void resize(int newCapacity) {
    int copyIndex;
    Item[] copy = (Item[]) new Object[newCapacity];
    
    if (newCapacity < capacity) { // resizing to 1/4
      for (int originalIndex = head; originalIndex < tail; originalIndex++) {
        copyIndex = originalIndex - head; // -head is equivalent to the displacement/shift 
                                          // to the left of the whole array
        copy[copyIndex] = queue[originalIndex];
      }
      tail -= head;
      head = 0;
    }
    else {
      for (int i = head; i < tail; i++) {
        copy[i] = queue[i];
      }
    }
    
    capacity = newCapacity;
    queue = copy;
  }

  public Iterator<Item> iterator() {
    return new ArrayIterator();
  }

  private class ArrayIterator implements Iterator<Item> {
    private int iteratorPosition = tail - 1;
    private Item[] shuffled;

    ArrayIterator() {
      shuffled = (Item[]) new Object[tail - head];
      for (int i = head; i < tail; i++) {
        shuffled[i-head] = queue[i];
      }

      StdRandom.shuffle(shuffled);
    }

    public boolean hasNext() {
      return iteratorPosition >= head;
    }

    public Item next() {
      if (!hasNext())
        throw new NoSuchElementException();

      Item item = shuffled[iteratorPosition--];
      // Item item = shuffled[iteratorPosition];
      // shuffled[iteratorPosition--] = null;
      return item;
    }
  }

  // [UncommentedEmptyMethodBody]
  public static void main(String[] args) {}
}