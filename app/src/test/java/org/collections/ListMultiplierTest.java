package org.collections;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Tests ListMultiplier class")
public class ListMultiplierTest {

  private static ListMultiplier multiplier;

  @BeforeEach
  public void setup() {
    multiplier = new ListMultiplier();
  }

  @AfterAll
  static void tearDown() {
    multiplier = null;
  }

  @Test
  @DisplayName("Should return correct value for an empty list")
  public void testMultiplyEmptyList() {
    assertEquals(1, multiplier.multiply(), "Result should be 1 for an empty list");
  }

  @Test
  @DisplayName("Should return given element for a single element list")
  public void testMultiplySingleElementList() {
    multiplier.add(5);
    assertEquals(5, multiplier.multiply(), "Result should be 5 for a single element list");
  }

  @Test
  @DisplayName("Should return product for a multiple element list")
  public void testMultiply_MultipleElementList_ReturnsProduct() {
    multiplier.add(2);
    multiplier.add(3);
    multiplier.add(4);
    assertEquals(24, multiplier.multiply(), "Result should be 24 for a multiple element list");
  }

  @Test
  @DisplayName("Should return correct value for a list with zero")
  public void testMultiply_ZeroInList_ReturnsZero() {
    multiplier.add(2);
    multiplier.add(0);
    multiplier.add(4);
    assertEquals(0, multiplier.multiply(), "Result should be 0 for a list with zero");
  }

  @Test
  @DisplayName("Should throw exception for null in list")
  public void testMultiply_NullInList_ThrowsNullPointerException() {
    assertThrows(NullPointerException.class, () -> multiplier.add(null), "Should throw NullPointerException for null in list");
  }
}
