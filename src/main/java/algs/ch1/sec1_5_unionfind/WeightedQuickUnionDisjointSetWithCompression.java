package algs.ch1.sec1_5_unionfind;

/**
 * União rápida (abordagem preguiçosa)
 */
public class WeightedQuickUnionDisjointSetWithCompression extends DisjointSet {
  int[] size;

  public WeightedQuickUnionDisjointSetWithCompression(int n) {
    id = new int[n];
    size = new int[n];
    count = n;

    for (int i = 0; i < id.length; ++i) {
      id[i] = i;
      size[i] = 0;
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
    }
    else if (pTreeSize > qTreeSize) {
      id[qRoot] = pRoot;
    }
    else {
      id[qRoot] = pRoot;
      size[pRoot]++;
    }

    count--;
  }

  protected int find(int p) {
    while (p != id[p]) {
      id[p] = id[id[p]];
      p = id[p];
    }

    return p;
  }
}