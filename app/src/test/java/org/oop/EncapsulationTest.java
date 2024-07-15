package org.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the Encapsulation class, its properties and its methods.
 */

public class EncapsulationTest {
  private static Employee employee;

  @BeforeAll
  static void init() {
    employee = new Employee("John Doe", 64, 1000);
  }

  @AfterAll
  static void tearDown() {
    employee = null;
  }

  // @Nested
  // class PrivateFields {
  // Wihtout private keyword, the variable is package-private. Still accessible here!
    @Test
    @DisplayName("Should not expose private fields")
    void testPrivateFields() {
      assertAll("Should not expose private fields",
        () -> assertThrows(
          NoSuchFieldException.class,
          () -> employee.getClass().getField("name"),
          "Field name should not be accessible"),
        () -> assertThrows(
          NoSuchFieldException.class,
          () -> employee.getClass().getField("age"),
          "Field age should not be accessible"),
        () -> assertThrows(
          NoSuchFieldException.class,
          () -> employee.getClass().getField("salary"),
          "Field salary should not be accessible"));
    }
  // }

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

  @Nested
  class PropertyTypes {
    @Test
    void testEmployeeNameType() {
      assertInstanceOf(String.class, employee.getName());
    }

    @Test
    void testEmployeeAgeType() {
      assertInstanceOf(Integer.class, employee.getAge());
    }

    @Test
    void testEmployeeYearlySalaryType() {
      assertInstanceOf(Double.class, employee.calculateYearlySalary());
    }
  }
}
