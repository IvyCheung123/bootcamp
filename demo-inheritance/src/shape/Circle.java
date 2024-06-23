package shape;

import java.math.BigDecimal;

// Shape is a class containing area() abstract method
// Circle is a class inherit Shape class

// final class cannot be extended
// public final class Circle extends Shape {
public class Circle extends Shape {

  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  public double getRadius() {
    return this.radius;
  }

  // abstract method is not allowed in normal class
  // public abstract String test();

  // 1. The parent class has the same method
  // 2. Complier will check if the parent class really has the same method
  // final method cannot be overrided in the child class
  @Override
  public final double area() {
    return BigDecimal.valueOf(this.radius).multiply(BigDecimal.valueOf(this.radius)).multiply(BigDecimal.valueOf(Math.PI)).doubleValue();
  }

  /*
  @Override // The method sleep() of type Circle must override or implement a supertype method
  public void sleep() {

  }
  */

  // Child class may have its own method
  public void sleep() {
    System.out.println("circle is sleeping ...");
  }

  public static void main(String[] args) {
    Circle c1 = new Circle(3.0d);
    System.out.println(c1.area()); // 28.274333882308138

    System.out.println(Shape.circleArea(3.0d)); // 28.274333882308138
  }

}
