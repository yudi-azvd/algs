package AlgorithmsPrincetonCourse.Queue;

interface IQueue<Item> {
  public void enqueue(Item item);
  
  public Item dequeue();

  public boolean isEmpty();
}