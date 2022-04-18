package algs.ch1.sec1_5_unionfind;

/**
 * União rápida (abordagem preguiçosa)
 */
public class WeightedQuickUnionDisjointSet extends DisjointSet {
  int[] size;
  int cost;
  int total;

  public WeightedQuickUnionDisjointSet(int n) {
    id = new int[n];
    size = new int[n];
    count = n;
    cost = 0;
    total = 0;

    for (int i = 0; i < id.length; ++i) {
      id[i] = i;
      size[i] = 1;
    }
  }

  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);

    int cost = 0;

    int pTreeSize = size[pRoot];
    int qTreeSize = size[qRoot];

    cost += 2;

    if (pRoot == qRoot) {
      return;
    }

    if (pTreeSize < qTreeSize) {
      id[pRoot] = qRoot;
      size[qRoot] += pTreeSize;
      cost += 3;
    }
    else {
      id[qRoot] = pRoot;
      size[pRoot] += qTreeSize;
      cost += 3;
    }

    count--;
    this.cost = cost;
    this.total += cost;
  }

  protected int find(int p) {
    while (p != id[p]) {
      p = id[p];
    }

    return p;
  }

  public int getCost() {
    return cost;
  }

  public int getTotal() {
    return total;
  }
}