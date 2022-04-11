package AlgorithmsPrincetonCourse.chap01.sec1_3.queue;

@SuppressWarnings("unchecked")
public class ResizingArrayQueue<Item> implements IQueue<Item> {
  private int head, tail;
  private int capacity;
  private Item[] queue;

  public ResizingArrayQueue() {
    head = 0;
    tail = 0;
    capacity = 1;
    queue = (Item[]) new Object[capacity];
  }

  public void enqueue(Item item) {
    if (tail == capacity-1) {
      resize(capacity*2);
    }

    queue[tail++] = item;
  }

  public Item dequeue() {
    if (isEmpty()) {
      throw new Error("queue is already empty");
    }

    Item item = queue[head];
    queue[head++] = null;

    int size = tail - head;
    if (size > 0 && size == capacity/4) {
      resize(capacity/2); // resizeSmaller
    }

    if (isEmpty()) {
      resize(1); // resizeSmaller
    }

    return item;
  }

  public boolean isEmpty() {
    return head == tail;
  }

  public String toString() {
    int i;
    String result = "";

    for (i = head; i < tail; i++) {
      result += queue[i] + ",";
    }

    return result;
  }

  // break into resizeBigger and resizeSmaller
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

  public static void main(String[] args) {
    ResizingArrayQueue<Integer> q = new ResizingArrayQueue<Integer>();

    q.enqueue(0);
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);
    q.enqueue(5);
    q.enqueue(6);
    q.enqueue(7);

    System.out.println("deq " + q.dequeue());
    System.out.println(q);

    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();

    q.enqueue(9);

    System.out.println("isEmpty " + q.isEmpty());
  }
}