package org.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the Employee class, its properties and its methods.
 */
public class ObjectTest {
  private Employee employee;

  @BeforeEach
  void init() {
    employee = new Employee("John Doe", 64, 1000);
  }

  @AfterEach
  void tearDown() {
    employee = null;
  }

  @Nested
  class Constructors {
    @Test
    void testEmployeeInstanceCreation() {
      assertNotNull(employee);
    }

    @Test
    void testEmployeeType() {
      assertInstanceOf(Employee.class, employee);
    }
  }
}
