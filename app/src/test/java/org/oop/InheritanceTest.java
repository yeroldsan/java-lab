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
      assertInstanceOf(manager.getClass(), manager);
    }
  }
}
