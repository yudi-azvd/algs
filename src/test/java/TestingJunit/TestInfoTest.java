package TestingJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;

class TestInfoTest {
  TestInfoTest(TestInfo testInfo) {
      assertEquals("TestInfoTest", testInfo.getDisplayName());           
  }

  @BeforeEach
  public void setUp(TestInfo testInfo) {
      String displayName = testInfo.getDisplayName();
      assertTrue(displayName.equals("display name of the method") ||
                 displayName.equals("testGetNameOfTheMethod(TestInfo)"));
  }

  @Test
  public void testGetNameOfTheMethod(TestInfo testInfo) {
      assertEquals("testGetNameOfTheMethod(TestInfo)",
                   testInfo.getDisplayName());                          
  }

  @Test
  @DisplayName("display name of the method")
  public void testGetNameOfTheMethodWithDisplayNameAnnotation(TestInfo testInfo) {
      assertEquals("display name of the method",
                   testInfo.getDisplayName());
  }
}