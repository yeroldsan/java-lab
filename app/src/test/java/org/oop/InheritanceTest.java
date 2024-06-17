package org.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the Inheritance class, its properties and its methods.
 */
public class InheritanceTest {
  private Manager manager;

  @BeforeEach
  void init() {
    manager = new Manager("Jane Doe", 32, 2000, 100);
  }

  @AfterEach
  void tearDown() {
    manager = null;
  }

  @Nested
  class Constructors {
    @Test
    void testManagerInstanceCreation() {
      assertNotNull(manager);
    }

    @Test
    void testManagerType() {
      assertInstanceOf(Manager.class, manager);
    }

    @Test
    void testManagerInheritance() {
      assertInstanceOf(Employee.class, manager);
    }
  }

  @Nested
  class PropertyTypes {
    @Test
    void testManagerNameType() {
      assertInstanceOf(String.class, manager.getName());
    }

    @Test
    void testManagerAgeType() {
      assertInstanceOf(Integer.class, manager.getAge());
    }

    @Test
    void testManagerYearlySalaryType() {
      assertInstanceOf(Double.class, manager.calculateYearlySalary());
    }

    @Test
    void testManagerBonusType() {
      assertInstanceOf(Double.class, manager.getBonus());
    }
  }

  @Nested
  class PropertyGetters {
    @Test
    void testNameEquality() {
      assertEquals("Jane Doe", manager.getName());
    }

    @Test
    void testAgeEquality() {
      assertEquals(32, manager.getAge());
    }

    @Test
    void testYearlySalaryEquality() {
      assertEquals(24100, manager.calculateYearlySalary());
    }

    @Test
    void testBonusEquality() {
      assertEquals(100, manager.getBonus());
    }

    @Test
    void testRaiseSalary() {
      manager.raiseSalary(10);
      assertEquals(2200, manager.getSalary());
    }
  }
}
