package shape;

import java.math.BigDecimal;

public abstract class Shape {
  // abstract class can create instance method without implementation
  // method without implementation -> abstract method
  public abstract double area();

  public static double circleArea(double radius) {
    return BigDecimal.valueOf(radius).multiply(BigDecimal.valueOf(radius)).multiply(BigDecimal.valueOf(Math.PI)).doubleValue();
  }

  // Polymorphism
  public static double totalArea(Shape[] shapes) {
    BigDecimal bd = BigDecimal.valueOf(0.0d);
    for (Shape shape : shapes) { // shape is object reference pointing to actual object (Circle / Square)
      bd = bd.add(BigDecimal.valueOf(shape.area()));
    }
    return bd.doubleValue();
  }

  public static void main(String[] args) {
    Shape[] shapes = new Shape[] {new Circle(3.0d), new Square(5.0d)};
    System.out.println(Shape.totalArea(shapes)); // 28.274333882308138 + 25 = 53.274333882308134

    StringBuilder sb = new StringBuilder("hello");
    sb.append("world");
    System.out.println(sb); // helloworld
  }
}
