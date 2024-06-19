package org.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the inheritance in Manager class, its properties and its methods.
 */
@DisplayName("Tests Manager class")
public class InheritanceTest {
  private static Manager manager;

  @BeforeAll
  static void init() {
    manager = new Manager("Jane Doe", 32, 2000, 100);
  }

  @AfterAll
  static void tearDown() {
    manager = null;
  }

  @Nested
  @DisplayName("Tests constructor")
  class Constructors {
    @Test
    @DisplayName("Should create a Manager object")
    void testManagerInstanceCreation() {
      assertNotNull(manager, "Should create a Manager object");
    }

    @Test
    @DisplayName("Should create an object of type Manager")
    void testManagerType() {
      assertInstanceOf(Manager.class, manager, "Should create an object of type Manager");
    }

    @Test
    @DisplayName("Should inherit from Employee class")
    void testManagerInheritance() {
      assertInstanceOf(Employee.class, manager, "Should inherit from Employee class");
    }
  }

  @Nested
  @DisplayName("Should return correct values for manager properties")
  class PropertyTypes {
    @Test
    void testManagerNameType() {
      assertInstanceOf(String.class, manager.getName(), "Name should be of type String");
    }

    @Test
    void testManagerAgeType() {
      assertInstanceOf(Integer.class, manager.getAge(), "Age should be of type Integer");
    }

    @Test
    void testManagerYearlySalaryType() {
      assertInstanceOf(Double.class, manager.calculateYearlySalary(), "Yearly salary should be of type Double");
    }

    @Test
    void testManagerBonusType() {
      assertInstanceOf(Double.class, manager.getBonus(), "Bonus should be of type Double");
    }
  }

  @Nested
  class PropertySetters {
    @Test
    void testSetName() {
      manager.setName("Mary Doe");
      assertEquals("Mary Doe", manager.getName(), "Name should be 'Mary Doe'");
    }

    @Test
    void testSetAge() {
      manager.setAge(40);
      assertEquals(40, manager.getAge(), "Age should be 40");
    }

    @Test
    void testSetSalary() {
      manager.setSalary(3000);
      assertEquals(3000, manager.getSalary(), "Salary should be 3000");
    }

    @Test
    void testSetBonus() {
      manager.setBonus(200);
      assertEquals(200, manager.getBonus(), "Bonus should be 200");
    }
  }

  @Test
  @DisplayName("Should not allow nagative values for object properties")
  void testNegativeValues() {
    assertAll("Should not allow negative values for object properties",
      () -> assertThrows(IllegalArgumentException.class, () -> manager.setAge(-1), "Should throw exception for negative age"),
      () -> assertThrows(IllegalArgumentException.class, () -> manager.setSalary(-1), "Should throw exception for negative salary"),
      () -> assertThrows(IllegalArgumentException.class, () -> manager.setBonus(-1), "Should throw exception for negative bonus"));
  }
}
