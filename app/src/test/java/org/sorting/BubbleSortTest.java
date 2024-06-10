package org.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortingTest {
  @Test 
  public void testBubbleSort() {
    int[] arr = {5, 2, 8, 3, 1, 6, 4};
    BubbleSort.sort(arr);
    int[] expected = {1, 2, 3, 4, 5, 6, 8};
    assertArrayEquals(expected, arr);
  }

  @Test
  public void testBubbleSortWithEmptyArray() {
    int[] arr = {};
    BubbleSort.sort(arr);
    int[] expected = {};
    assertArrayEquals(expected, arr);
  }

  @Test
  public void testBubbleSortWithSingleElement() {
    int[] arr = {5};
    BubbleSort.sort(arr);
    int[] expected = {5};
    assertArrayEquals(expected, arr);
  }
}
