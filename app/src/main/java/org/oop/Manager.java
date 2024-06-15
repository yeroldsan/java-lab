package org.oop;

public class Manager extends Employee {
  private double bonus;

  /**
   * Class constructor
   * 
   * @param name   the name of the manager
   * @param age    the age of the manager
   * @param salary the salary of the manager
   * @param bonus  the bonus of the manager
   */
  public Manager(String name, int age, double salary, double bonus) {
    super(name, age, salary);
    this.bonus = bonus;
  }

  /**
   * Returns the bonus of the manager.
   * 
   * @return the bonus of the manager
   */
  public double getBonus() {
    return bonus;
  }

  /**
   * Sets the bonus of the manager.
   * 
   * @param bonus the new bonus of the manager
   */
  public void setBonus(double bonus) {
    this.bonus = bonus;
  }

  /**
   * Calculates the yearly salary of the manager.
   * 
   * @return the yearly salary of the manager
   */
  @Override
  public double calculateYearlySalary() {
    return super.calculateYearlySalary() + getBonus();
  }
}
