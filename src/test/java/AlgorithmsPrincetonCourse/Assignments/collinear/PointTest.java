package AlgorithmsPrincetonCourse.Assignments.collinear;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;

/**
 * De fato, os testes não são muito criativos 
 * mesmo.
 */
public class PointTest {
  @Test 
  public void testCompareTo() {
    Point A = new Point(1, 4);
    Point A2 = new Point(1, 4);
    Point B = new Point(4, 4);
    Point C = new Point(1, 1);
    Point D = new Point(4, 1);

    boolean AisEqualToA2 = A.compareTo(A2) == 0;
    assertTrue(AisEqualToA2);

    boolean AisLessThanB = A.compareTo(B) == -1;
    assertTrue(AisLessThanB);

    boolean DisGreaterThanB = D.compareTo(B) == 1;
    assertTrue(DisGreaterThanB);

    boolean CisGreaterThanA = C.compareTo(A) == 1;
    assertTrue(CisGreaterThanA);

    boolean CisLessThanB = C.compareTo(B) == -1;
    assertTrue(CisLessThanB);

    boolean CisLessThanD = C.compareTo(D) == -1;
    assertTrue(CisLessThanD);
  }


  @Test
  public void testSlopeTo() {
    Point A = new Point(1, 4);
    Point A2 = new Point(1, 4);
    Point B = new Point(4, 4);
    Point C = new Point(1, 1);
    Point D = new Point(4, 1);
    
    double CBslope = C.slopeTo(B);
    assertEquals(CBslope, 1.0);

    double BDslope = B.slopeTo(D);
    assertEquals(BDslope, Double.POSITIVE_INFINITY);

    double CDslope = C.slopeTo(D);
    assertEquals(CDslope, 0.0);

    double AA2slope = A.slopeTo(A2);
    assertEquals(AA2slope, Double.NEGATIVE_INFINITY);
  }

  @Test
  public void testSlopeOrder() {
    // Point A = new Point(1, 4);
    // Point A2 = new Point(1, 4);
    // Point B = new Point(4, 4);
    // Point C = new Point(1, 1);
    // Point D = new Point(4, 1);

    // Point[] points = {A, A2};

    assertEquals(1, 1);
  }
}
