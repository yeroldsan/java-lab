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

  @Nested
  class PropertyValues {
    @Test
    void testNameEquality() {
      assertEquals("John Doe", employee.getName());
    }

    @Test
    void testAgeEquality() {
      assertEquals(64, employee.getAge());
    }

    @Test
    void testYearlySalaryEquality() {
      assertEquals(12000, employee.calculateYearlySalary());
    }

    @Test
    void testRaiseSalary() {
      employee.raiseSalary(10);
      assertEquals(1100, employee.getSalary());
    }
  }
}
