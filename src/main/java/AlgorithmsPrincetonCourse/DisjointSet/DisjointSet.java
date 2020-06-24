package AlgorithmsPrincetonCourse.DisjointSet;

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

  abstract protected void union(int p, int q);
}