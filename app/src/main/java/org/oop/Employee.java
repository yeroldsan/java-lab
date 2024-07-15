package org.oop;

/**
 * Exercise: Encapsulation
 * 
 * 1. Create an Employee class that has the following properties and methods.
 * 
 * The Employee class should have the following fields:
 * 
 * - name: String
 * - age: int
 * - salary: double
 * 
 * The Employee class should have the following constructors:
 * 
 * - Employee(String, int, double)
 * 
 * The Employee class should have the following setters:
 * 
 * - setName(String)
 * - setAge(int)
 * - setSalary(double)
 * 
 * Encapsulate the Employee class by making its fields private and providing
 * public methods to access them.
 * 
 * The Employee class should have the following getters:
 * 
 * - getName(): String
 * - getAge(): int
 * - getSalary(): double
 * 
 * The Employee class should have the following methods:
 * 
 * - calculateYearlySalary(): double
 * - raiseSalary(double)
 * 
 * The raiseSalary method should raise the salary of the employee by a given
 * percentage.
 * 
 */

public class Employee {
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
