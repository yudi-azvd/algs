package algs.ch1.sec1_5_unionfind;

public abstract class DisjointSet {
  protected int[] id;
  protected int count;

  public int count() {
    return count;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  };

  abstract protected int find(int p);

  abstract public void union(int p, int q);
}