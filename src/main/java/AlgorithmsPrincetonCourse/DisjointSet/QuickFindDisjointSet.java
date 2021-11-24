package AlgorithmsPrincetonCourse.DisjointSet;

/**
 * Busca rápida (abordagem ansiosa/impaciente)
 */
public class QuickFindDisjointSet extends DisjointSet {
  private int cost;
  private int total;

  public QuickFindDisjointSet(int size) {
    id = new int[size];
    count = size;
    cost = 0;
    total = 0;

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
    int cost = 0;

    if (firstGroupId == secondGroupId)
      return;

    for (int i = 0; i < id.length; ++i) {
      cost++;
      if (id[i] == secondGroupId) {
        cost++;
        id[i] = firstGroupId;
      }
    }

    total += cost;
    this.cost = cost;
    count--;
  }

  public int getCost() {
    return cost;
  }

  public int getTotal() {
    return total;
  }
}