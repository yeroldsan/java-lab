package org.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Tests the Employee class, its properties and its methods.
 */
public class ObjectTest {
  private static List<Employee> employees;

  @BeforeAll
  static void init() {
    employees = getEmployees();
  }

  @AfterAll
  static void tearDown() {
    employees = null;
  }

  @Test
  @DisplayName("Should return a list of employees")
  void testEmployeeList() {
    assertNotNull(employees, "Should return a list of employees");
  }

  @Test
  @DisplayName("Should create an object of type Employee")
  void testInstanceType() {
    for (Employee employee : employees) {
      assertInstanceOf(Employee.class, employee, "Should create an object of type Employee");
    }
  }

  @Test
  @DisplayName("Should return correct values for employee properties")
  void testEmployeePropertiesValues() {
    assertAll("Should return correct values for employee properties",
      () -> assertEquals("John Doe", employees.get(0).getName(), "Name should be 'John Doe'"),
      () -> assertEquals(64, employees.get(0).getAge(), "Age should be 64"),
      () -> assertEquals(1000, employees.get(0).getSalary(), "Salary should be 1000"),
      () -> assertEquals("Jane Doe", employees.get(1).getName(), "Name should be 'Jane Doe'"),
      () -> assertEquals(32, employees.get(1).getAge(), "Age should be 32"),
      () -> assertEquals(2000, employees.get(1).getSalary(), "Salary should be 2000"),
      () -> assertEquals("Janet Doe", employees.get(2).getName(), "Name should be 'Janet Doe'"),
      () -> assertEquals(40, employees.get(2).getAge(), "Age should be 40"),
      () -> assertEquals(3000, employees.get(2).getSalary(), "Salary should be 3000"));
  }

  @Test
  @DisplayName("Should return correct types for employee properties")
  void testEmployeePropertyTypes() {
    for (Employee employee : employees) {
      assertAll("Should return correct types for employee properties",
        () -> assertInstanceOf(String.class, employee.getName(), "Name should be a string"),
        () -> assertInstanceOf(Integer.class, employee.getAge(), "Age should be an integer"),
        () -> assertInstanceOf(Double.class, employee.getSalary(), "Salary should be a double"));
    }
  }

  @Test
  @DisplayName("Should return correct string representation for each employee")
  void testToString() {
    assertAll("Should return correct string representation for each employee",
      () -> assertEquals("Employee{name='John Doe', age=64, salary=1000.00}", employees.get(0).toString(), "String representation should be 'Employee{name='John Doe', age=64, salary=1000.00}'"),
      () -> assertEquals("Employee{name='Jane Doe', age=32, salary=2000.00}", employees.get(1).toString(), "String representation should be 'Employee{name='Jane Doe', age=32, salary=2000.00}'"),
      () -> assertEquals("Employee{name='Janet Doe', age=40, salary=3000.00}", employees.get(2).toString(), "String representation should be 'Employee{name='Janet Doe', age=40, salary=3000.00}'"));
  }

  @Test
  @DisplayName("Should set new values for employee properties")
  void testSetters() {
    Employee employee = employees.get(1);
    employee.setName("Mary Doe");
    employee.setAge(32);
    employee.setSalary(4000);
    assertAll("Should set new values for employee properties",
      () -> assertEquals("Mary Doe", employee.getName(), "Name should be 'Mary Doe'"),
      () -> assertEquals(32, employee.getAge(), "Age should be 32"),
      () -> assertEquals(4000, employee.getSalary(), "Salary should be 4000"));
  }

  @Nested
  class PropertySetterEdgeCaseTests {
    @Test
    void shouldNotAcceptNegativeAge() {
      Employee employee = employees.get(0);
      IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> employee.setAge(-1), "Should not accept negative age");
      assertEquals("Age cannot be negative", exception.getMessage());
    }

    @Test
    void shouldNotAcceptNegativeSalary() {
      Employee employee = employees.get(1);
      IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> employee.setSalary(-1000.0), "It should throw an exception when salary is negative");
      assertEquals("Salary cannot be negative", exception.getMessage());
    }
  }

  private static List<Employee> getEmployees() {
    return List.of(
      new Employee("John Doe", 64, 1000),
      new Employee("Jane Doe", 32, 2000),
      new Employee("Janet Doe", 40, 3000));
  }
}
