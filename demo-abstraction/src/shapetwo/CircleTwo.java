package shapetwo;

import java.math.BigDecimal;

public class CircleTwo implements ShapeTwo {

  private double radius;

  public CircleTwo(double radius) {
    this.radius = radius;
  }

  @Override
  public double area() {
    return BigDecimal.valueOf(this.radius)
    .multiply(BigDecimal.valueOf(this.radius))
    .multiply(BigDecimal.valueOf(Math.PI))
    .doubleValue();
  }

  public static void main(String[] args) {
    CircleTwo c1 = new CircleTwo(3.0);
    System.out.println(c1.area());
  }

}
