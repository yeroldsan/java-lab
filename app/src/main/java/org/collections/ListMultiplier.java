package org.collections;

import java.util.LinkedList;

/**
 * Implement a ListMultiplier class that allows you to add integers to a list
 * and multiply all the numbers in the list together.
 * 
 * The ListMultiplier class should have the following methods and properties:
 * 
 * - list: A private LinkedList of integers.
 * - add(Integer num): Public void method that takes an integer as parameter and
 * adds it to the list. If the parameter is null, the method should throw an exception.
 * - multiply(): Public method that multiplies all the numbers in the list and returns the result.
 */

public class ListMultiplier {
  private LinkedList<Integer> list = new LinkedList<>();

  /**
   * Takes an integer as parameter and adds it to the list
   *
   * @param num the number to add
   */
  public void add(Integer num) {
    if (num == null) {
      throw new NullPointerException("Null value is not allowed");
    }
    list.add(num);
  }

  /**
   * Multiplies all the numbers in the list.
   *
   * @return the product of all the numbers in the list as an Integer
   */
  public Integer multiply() {
    if (list.isEmpty()) {
      throw new IllegalStateException("List is empty");
    }
    int result = 1;
    for (Integer num : list) {
      result *= num;
    }
    return result;
  }
}
