package org.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the Encapsulation class, its properties and its methods.
 */

public class EncapsulationTest {
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
  class PrivateFields {
    @Test
    void testPrivateNameField() {
      assertThrows(
        NoSuchFieldException.class,
        () -> employee.getClass().getField("name"),
        "Field name should be private"
      );
    }
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
