package AlgorithmsPrincetonCourse.DisjointSet;

/**
 * União rápida (abordagem preguiçosa)
 */
public class WeightedQuickUnionDisjointSet extends DisjointSet {

  public WeightedQuickUnionDisjointSet(int size) {
    id = new int[size];
    count = size;

    for (int i = 0; i < id.length; ++i) {
      id[i] = i;
    }
  }

  public void union(int p, int q) {
  }

  protected int find(int p) {
    return p;
  }
}