package AlgorithmsPrincetonCourse.DisjointSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class QuickFindTest {
  @Test
  public void connections_should_be_reflexive() {
    QuickFindDisjointSet set = new QuickFindDisjointSet(2);

    assertTrue(set.connected(1, 1));
    assertTrue(set.connected(0, 0));
  }

  
  @Test
  public void connections_should_be_symmetric() {
    QuickFindDisjointSet set = new QuickFindDisjointSet(4);

    set.union(1, 3);

    assertEquals(true, set.connected(1, 3));
    assertEquals(true, set.connected(3, 1));
  }


  @Test
  public void should_be_able_to_unify_connected_groups() {
    QuickFindDisjointSet set = new QuickFindDisjointSet(10);

    // grupo 1
    set.union(0, 5);
    set.union(6, 5);

    assertEquals(false, set.connected(0, 3));
    
    // grupo 2
    set.union(7, 8);
    set.union(8, 3);

    // conectar os dois grupos
    set.union(7, 6);

    assertEquals(true, set.connected(0, 3));
  }
}
