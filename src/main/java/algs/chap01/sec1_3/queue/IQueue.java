package algs.chap01.sec1_3.queue;

interface IQueue<Item> {
  public void enqueue(Item item);
  
  public Item dequeue();

  public boolean isEmpty();
}