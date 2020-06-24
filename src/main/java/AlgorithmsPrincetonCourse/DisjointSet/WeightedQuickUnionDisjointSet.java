package AlgorithmsPrincetonCourse.DisjointSet;

/**
 * União rápida (abordagem preguiçosa)
 */
public class WeightedQuickUnionDisjointSet extends DisjointSet {
  int[] size;

  public WeightedQuickUnionDisjointSet(int n) {
    id = new int[n];
    size = new int[n];
    count = n;

    for (int i = 0; i < id.length; ++i) {
      id[i] = i;
    }

    for (int i = 0; i < id.length; ++i) {
      size[i] = 1;
    }
  }

  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);

    int pTreeSize = size[pRoot];
    int qTreeSize = size[qRoot];

    if (pRoot == qRoot) {
      return;
    }

    if (pTreeSize < qTreeSize) {
      id[pRoot] = qRoot;
      size[qRoot] += pTreeSize;
    }
    else {
      id[qRoot] = pRoot;
      size[pRoot] += qTreeSize;
    }

    count--;
  }

  protected int find(int p) {
    while (p != id[p]) {
      p = id[p];
    }

    return p;
  }
}