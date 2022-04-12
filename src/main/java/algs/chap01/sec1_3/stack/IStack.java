package algs.chap01.sec1_3.stack;

interface IStack<Item> {
  public void push(Item item);

  public Item pop();

  public boolean isEmpty();
}