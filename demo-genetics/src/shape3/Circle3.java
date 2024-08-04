package shape3;

public class Circle3 extends Shape3 {
  private double radius;

  public Circle3(double radius) {
    super(); // new Shape3 object
    this.radius = radius;
  }

  @Override
  public double area() {
    return this.radius * this.radius * Math.PI;
  }
}
