package algs.chap01.sec1_3.queue;

public interface IGeneralizedQueue<Item> {
  /**
   * Returns true if this queue is empty.
   * 
   * @return {@code true} if this queue is empty; {@code false} otherwise
   */
  public boolean isEmpty();


  /**
   * Add an item
   */
  public void insert(Item x);

  /**
   * Delete and return the kth least recently inserted item
   */
  public Item delete(int k);
}