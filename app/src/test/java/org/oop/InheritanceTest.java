package org.oop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;

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
  @DisplayName("Constructors")
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
  @DisplayName("Property type")
  class PropertyTypes {
    @Test
    @DisplayName("Should have name of type String")
    void testManagerNameType() {
      assertInstanceOf(String.class, manager.getName(), "Name should be of type String");
    }

    @Test
    @DisplayName("Should have age of type Integer")
    void testManagerAgeType() {
      assertInstanceOf(Integer.class, manager.getAge(), "Age should be of type Integer");
    }

    @Test
    @DisplayName("Should have salary of type Double")
    void testManagerYearlySalaryType() {
      assertInstanceOf(Double.class, manager.calculateYearlySalary(), "Yearly salary should be of type Double");
    }

    @Test
    @DisplayName("Should have bonus of type Double")
    void testManagerBonusType() {
      assertInstanceOf(Double.class, manager.getBonus(), "Bonus should be of type Double");
    }
  }

  @Nested
  @DisplayName("Setters and getters")
  class PropertySetters {
    @Test
    @DisplayName("Should set a new name for the manager")
    void testSetName() {
      manager.setName("Mary Doe");
      assertEquals("Mary Doe", manager.getName(), "Name should be 'Mary Doe'");
    }

    @Test
    @DisplayName("Should set a new age for the manager")
    void testSetAge() {
      manager.setAge(40);
      assertEquals(40, manager.getAge(), "Age should be 40");
    }

    @Test
    @DisplayName("Should set a new salary for the manager")
    void testSetSalary() {
      manager.setSalary(3000);
      assertEquals(3000, manager.getSalary(), "Salary should be 3000");
    }

    @Test
    @DisplayName("Should set a new bonus for the manager")
    void testSetBonus() {
      manager.setBonus(200);
      assertEquals(200, manager.getBonus(), "Bonus should be 200");
    }
  }

  @Nested
  @DisplayName("Edge cases")
  class EdgeCases {
    @Test
    @DisplayName("Should not set a negative age for the manager")
    void testSetNegativeAge() {
      assertThrows(IllegalArgumentException.class, () -> manager.setAge(-1),
          "Should throw exception for negative age");
    }

    @Test
    @DisplayName("Should not set a negative salary for the manager")
    void testSetNegativeSalary() {
      assertThrows(IllegalArgumentException.class, () -> manager.setSalary(-1),
          "Should throw exception for negative salary");
    }

    @Test
    @DisplayName("Should not set a negative bonus for the manager")
    void testSetNegativeBonus() {
      assertThrows(IllegalArgumentException.class, () -> manager.setBonus(-1),
          "Should throw exception for negative bonus");
    }
  }
}
