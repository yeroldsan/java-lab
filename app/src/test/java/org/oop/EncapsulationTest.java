package org.oop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;

/**
 * Tests the Encapsulation class, its properties and its methods.
 */
@DisplayName("Encapsulation tests")
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

  @Nested
  class Constructors {
    @Test
    @DisplayName("Should create an instance of Employee")
    void testEmployeeInstanceCreation() {
      assertNotNull(employee, "Should create an instance of Employee");
    }

    @Test
    @DisplayName("Should set the name, age and salary")
    void testEmployeeType() {
      assertInstanceOf(Employee.class, employee, "Should create an object of type Employee");
    }
  }

  @Nested
  class PropertyTypes {
    @Test
    @DisplayName("Should return correct type for employee name")
    void testEmployeeNameType() {
      assertInstanceOf(String.class, employee.getName(), "Name should be a string");
    }

    @Test
    @DisplayName("Should return correct type for employee age")
    void testEmployeeAgeType() {
      assertInstanceOf(Integer.class, employee.getAge(), "Age should be an integer");
    }

    @Test
    @DisplayName("Should return correct type for employee salary")
    void testEmployeeYearlySalaryType() {
      assertInstanceOf(Double.class, employee.calculateYearlySalary(), "Yearly salary should be a double");
    }
  }
}
