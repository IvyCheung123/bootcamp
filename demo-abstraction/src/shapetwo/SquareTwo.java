package shapetwo;

import java.math.BigDecimal;

public class SquareTwo implements ShapeTwo {

  private double length;

  public SquareTwo(double length) {
    this.length = length;
  }

  @Override
  public double area() {
    return BigDecimal.valueOf(this.length)
    .multiply(BigDecimal.valueOf(this.length))
    .doubleValue();
  }

}
