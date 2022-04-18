package algs.ch1.sec1_5_unionfind;

/**
* União rápida (abordagem preguiçosa)
*/
public class QuickUnionDisjointSet extends DisjointSet {
  private int cost;
  private int total;

  public QuickUnionDisjointSet(int size) {
    id = new int[size];
    count = size;
    cost = 0;
    total = 0;

    for (int i = 0; i < id.length; ++i) {
      id[i] = i;
    }
  }
  
  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    
    if (pRoot == qRoot) {
      return;
    }

    id[qRoot] = pRoot;
    count--;
    cost++;
  }
  
  protected int find(int p) {
    int cost = 0;
    cost++;
    while (p != id[p]) {
      cost++;
      p = id[p];
    }

    this.cost = cost;
    this.total += cost;

    return p;
  }

  public int getCost() {
    return cost;
  }

  public int getTotal() {
    return total;
  }
}