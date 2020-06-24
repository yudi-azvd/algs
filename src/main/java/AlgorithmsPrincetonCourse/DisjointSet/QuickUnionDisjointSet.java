package AlgorithmsPrincetonCourse.DisjointSet;

/**
* União rápida (abordagem preguiçosa)
*/
public class QuickUnionDisjointSet extends DisjointSet {
  public QuickUnionDisjointSet(int size) {
    id = new int[size];
    count = size;

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
  }
  
  protected int find(int p) {
    while (p != id[p]) {
      p = id[p];
    }

    return p;
  }
}