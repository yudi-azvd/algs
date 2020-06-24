package AlgorithmsPrincetonCourse.DisjointSet;

/**
 * União rápida (abordagem preguiçosa)
 */
public class WeightedQuickUnionDisjointSet extends DisjointSet {
  int[] height;

  public WeightedQuickUnionDisjointSet(int size) {
    id = new int[size];
    height = new int[size];
    count = size;

    for (int i = 0; i < id.length; ++i) {
      id[i] = i;
    }

    for (int i = 0; i < id.length; ++i) {
      height[i] = 1;
    }
  }

  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);

    int pHeight = height[pRoot];
    int qHeight = height[qRoot];

    if (pRoot == qRoot) {
      return;
    }

    if (pHeight < qHeight) {
      id[pRoot] = qRoot;
      height[qRoot] += height[pRoot];
    }
    else {
      id[qRoot] = pRoot;
      height[qRoot] +=height[pRoot];
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