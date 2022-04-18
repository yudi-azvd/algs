package algs.ch1.sec1_3_collections.queue;

interface IQueue<Item> {
  public void enqueue(Item item);
  
  public Item dequeue();

  public boolean isEmpty();
}