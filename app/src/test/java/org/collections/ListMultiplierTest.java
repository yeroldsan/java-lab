package org.collections;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;

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
  public void testMultiply_EmptyList_ReturnsOne() {
    assertEquals(1, multiplier.multiply());
  }

  @Test
  public void testMultiply_SingleElementList_ReturnsElement() {
    multiplier.add(5);
    assertEquals(5, multiplier.multiply());
  }

  @Test
  public void testMultiply_MultipleElementList_ReturnsProduct() {
    multiplier.add(2);
    multiplier.add(3);
    multiplier.add(4);
    assertEquals(24, multiplier.multiply());
  }

  @Test
  public void testMultiply_ZeroInList_ReturnsZero() {
    multiplier.add(2);
    multiplier.add(0);
    multiplier.add(4);
    assertEquals(0, multiplier.multiply());
  }

  @Test
  public void testMultiply_NullInList_ThrowsNullPointerException() {
    assertThrows(NullPointerException.class, () -> multiplier.add(null));
  }
}
