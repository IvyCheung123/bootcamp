package com.bootcamp.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data // Child.class should not use Data -> control callSuper manually
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true) // !!!!
@AllArgsConstructor
public class Employee extends Person1 {
  private int salary;

  // will not inherit Person1 Constructor
  public Employee (String name, int age, int salary) {
    super(name, age);
    this.salary = salary;
  }

  public static void main(String[] args) {
    Employee e1 = new Employee("John", 10, 10_000);
    Employee e2 = new Employee("John", 20, 10_000);

    System.out.println(e1.getName()); // John

    System.out.println(e1.equals(e2)); // true, compare salary only, by default will not compare Parent attributes
    // false, after @EqualsAndHashCode(callSuper = true)

    System.out.println(e1); // include Parent attributes after @ToString(callSuper = true)
  }
}
