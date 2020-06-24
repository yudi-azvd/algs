package AlgorithmsPrincetonCourse.DisjointSet;


/**
 * Busca rápida (abordagem ansiosa/impaciente)
 */
public class QuickFindDisjointSet extends DisjointSet {

  public QuickFindDisjointSet(int size) {
    id = new int[size];
    count = size;

    for (int i = 0; i < id.length; ++i) {
      id[i] = i;
    }
  }

  protected int find(int p) {
    return id[p];
  }

  public void union(int p, int q) {
    int firstGroupId = id[p];
    int secondGroupId = id[q];

    if (firstGroupId == secondGroupId)
      return;

    for (int i = 0; i < id.length; ++i) {
      if (id[i] == secondGroupId) {
        id[i] = firstGroupId;
      }
    }

    count--;
  }
}