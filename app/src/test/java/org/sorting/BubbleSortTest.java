package org.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

@DisplayName("BubbleSort class tests")
public class BubbleSortTest {

  @Test
  @DisplayName("Should sort the array in ascending order") 
  public void testBubbleSort() {
    int[] arr = {5, 2, 8, 3, 1, 6, 4};
    BubbleSort.sort(arr);
    int[] expected = {1, 2, 3, 4, 5, 6, 8};
    assertArrayEquals(expected, arr, "Should sort the array in ascending order");
  }

  @Test
  @DisplayName("Should sort the array in asc order with negative numbers")
  public void testBubbleSortWithNegativeNumbers() {
    int[] arr = {5, -2, 8, -3, 1, 6, -4};
    BubbleSort.sort(arr);
    int[] expected = {-4, -3, -2, 1, 5, 6, 8};
    assertArrayEquals(expected, arr, "Should sort the array in ascending order with negative numbers");
  }

  @Test
  @DisplayName("Test bubble sort with empty array")
  public void testBubbleSortWithEmptyArray() {
    int[] arr = {};
    BubbleSort.sort(arr);
    int[] expected = {};
    assertArrayEquals(expected, arr, "Should return an empty array");
  }

  @Test
  @DisplayName("Should return the same array for a single element")
  public void testBubbleSortWithSingleElement() {
    int[] arr = {5};
    BubbleSort.sort(arr);
    int[] expected = {5};
    assertArrayEquals(expected, arr, "Should return the same array for a single element");
  }
}
