package org.oop;

/**
 * Exercise: Implementing a Employee class
 * 
 * Objective: Create an Employee class with encapsulated fields and related
 * methods.
 * 
 * Steps:
 * 1. Define the Employee class with the following private fields:
 * - name (String)
 * - age (int)
 * - salary (double)
 * 
 * 2. Create a constructor for the Employee class that initializes these fields:
 * - Employee(String name, int age, double salary)
 * 
 * 3. Implement public setter methods for each field:
 * - void setName(String name)
 * - void setAge(int age)
 * - void setSalary(double salary)
 * 
 * 4. Implement public getter methods for each field:
 * - String getName()
 * - int getAge()
 * - double getSalary()
 * 
 * 5. Add a method to calculate the yearly salary:
 * - double calculateYearlySalary()
 * - This method should return the salary multiplied by 12.
 * 
 * 6. Add a method to raise the salary by a given percentage:
 * - void raiseSalary(double percentage)
 * - This method should increase the salary by the given percentage.
 * 
 * 7. Override the toString method to provide a string representation of the
 * employee:
 * - public String toString()
 * 
 * Example Usage:
 * Employee emp = new Employee("John Doe", 30, 50000);
 * emp.raiseSalary(10); // Raises salary by 10%
 * double yearlySalary = emp.calculateYearlySalary(); // Should return the
 * yearly salary
 */

public class Employee {

  // Wihtout private keyword, the variable is still accessible at package level!
  private String name;
  private int age;
  private double salary;

  /**
   * Class constructor. Creates an Employee object.
   *
   * @param name   the name of the employee
   * @param age    the age of the employee
   * @param salary the salary of the employee
   */
  public Employee(String name, int age, double salary) {
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  /**
   * Returns a string representation of the employee.
   *
   * @return a string representation of the employee
   */
  @Override
  public String toString() {
    return String.format(
      "Employee{name='%s', age=%d, salary=%.2f}",
      getName(),
      getAge(),
      getSalary());
  }

  /**
   * Returns the name of the employee.
   *
   * @return the name of the employee
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the age of the employee.
   *
   * @return the age of the employee
   */
  public int getAge() {
    return age;
  }

  /**
   * Returns the salary of the employee.
   *
   * @return the salary of the employee
   */
  public double getSalary() {
    return salary;
  }

  /**
   * Sets the name of the employee.
   *
   * @param name the new name of the employee
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the age of the employee.
   *
   * @param age the new age of the employee
   */
  public void setAge(int age) {
    if (age < 0) {
      throw new IllegalArgumentException("Age cannot be negative");
    }
    this.age = age;
  }

  /**
   * Sets the salary of the employee.
   *
   * @param salary the new salary of the employee
   * @throws IllegalArgumentException if the salary is negative
   */
  public void setSalary(double salary) {
    if (salary < 0) {
      throw new IllegalArgumentException("Salary cannot be negative");
    }
    this.salary = salary;
  }

  /**
   * Calculates the yearly salary of the employee.
   *
   * @return the yearly salary of the employee
   */
  public double calculateYearlySalary() {
    return getSalary() * 12;
  }

  /**
   * Raises the salary of the employee by a given percentage.
   *
   * @param percentage the percentage by which to raise the salary
   */
  public void raiseSalary(double percentage) {
    double raise = getSalary() * percentage / 100;
    double newSalary = getSalary() + raise;
    setSalary(newSalary);
  }
}
