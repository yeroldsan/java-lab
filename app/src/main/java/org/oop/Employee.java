package org.oop;

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
}
