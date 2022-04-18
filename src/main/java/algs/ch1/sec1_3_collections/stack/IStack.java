package algs.ch1.sec1_3_collections.stack;

interface IStack<Item> {
  public void push(Item item);

  public Item pop();

  public boolean isEmpty();
}