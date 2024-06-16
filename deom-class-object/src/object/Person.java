package object;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Person {
  // Attributes
  private String firstName;
  private String lastName;
  private double weight;
  private double height;

  // Empty Constructor
  public Person() {

  }

  // All Arguments Constructor
  public Person(String firstName, String lastName, double weight, double height) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.weight = weight;
    this.height = height;
  }

  // Instance method
  // setter getter
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public void setWeight(double weight) {
    this.weight = weight;
  }
  public void setHeight(double height) {
    this.height = height;
  }
  public String getFirstName() {
    return this.firstName;
  }
  public String getLastName() {
    return this.lastName;
  }
  
  public double getWeight() {
    return this.weight;
  }
  public double getHeight() {
    return this.height;
  }
  // Instance method
  // Attributes Presentation
  public String fullName() {
    return this.firstName + " " + this.lastName;
  }
  public double bmi() {
    return BigDecimal.valueOf(this.weight)
    .divide(BigDecimal.valueOf(Math.pow(this.height, 2)), RoundingMode.HALF_UP)
    .doubleValue();
  }
  public String toString() {
    return "Full Name: " + this.firstName + " " + this.lastName + ", Weight: " + this.weight + "kg , Height: " + this.height + "m, BMI: " + BigDecimal.valueOf(this.weight)
    .divide(BigDecimal.valueOf(Math.pow(this.height, 2)), RoundingMode.HALF_UP)
    .doubleValue();
  }

  // Static method
  public static double bmi(double weight, double height) {
    return BigDecimal.valueOf(weight)
    .divide(BigDecimal.valueOf(Math.pow(height, 2)), RoundingMode.HALF_UP)
    .doubleValue();
  }

  public static void main(String[] args) {
    // Create a person with defined empty constructor if no constructor
    // by default the class implicity has an empty constructor
    Person p1 = new Person(); // "Person()" -> constructor
    p1.setFirstName("Alan");
    p1.setLastName("Chan");
    p1.setWeight(50);
    p1.setHeight(1.6);
    System.out.println(p1.fullName());
    System.out.println(p1.bmi());
    System.out.println(p1.toString());
    System.out.println(Person.bmi(60, 1.7));

    // Create a person object with given attribute values
    Person p2 = new Person("Ben", "Cheung", 60, 1.7);
    System.out.println(p2.toString());

    // Swap
    Person p3 = p1; // p3 = Alan
    System.out.println(p3.toString()); // Alan
    System.out.println(p3.equals(p1)); // true
    System.out.println(p3 == p1); // true, same memory address
    System.out.println(System.identityHashCode(p1)); // 2101973421 -> 1943105171, Person@73d16e93
    System.out.println(System.identityHashCode(p2)); // 685325104 -> 1704856573, Person@659e0bfd
    System.out.println(System.identityHashCode(p3)); // 2101973421 -> 1943105171, Person@73d16e93
    p3.setFirstName("Chris");
    System.out.println(p1.toString()); // Chris, 19.5
    System.out.println(p2.toString()); // Ben, 20.8
    System.out.println(p3.toString()); // Chris, 19.5
    System.out.println(p1.equals(p3)); // true
    System.out.println(p1 == p3); // true, same memory address
    p1 = p2; // p1 = Ben
    System.out.println(p1.toString()); // Ben, 20.8
    System.out.println(p2.toString()); // Ben, 20.8
    System.out.println(p3.toString()); // Chris, 19.5
    System.out.println(System.identityHashCode(p1)); // 685325104 -> 1704856573, Person@659e0bfd
    System.out.println(System.identityHashCode(p2)); // 685325104 -> 1704856573, Person@659e0bfd
    System.out.println(System.identityHashCode(p3)); // 2101973421 -> 1943105171, Person@73d16e93
    p2 = p3; // p2 = Chris
    System.out.println(p1.toString()); // Ben, 20.8
    System.out.println(p2.toString()); // Chris, 19.5
    System.out.println(p3.toString()); // Chris, 19.5
    System.out.println(System.identityHashCode(p1)); // 685325104 -> 1704856573, Person@659e0bfd
    System.out.println(System.identityHashCode(p2)); // 2101973421 -> 1943105171, Person@73d16e93
    System.out.println(System.identityHashCode(p3)); // 2101973421 -> 1943105171, Person@73d16e93
  }
}
