package shape3;

public class Square3 extends Shape3{
  private double length;

  public Square3(double length) {
    super();
    this.length = length;
  }

  @Override
  public double area() {
    return Math.pow(this.length, 2);
  }
}
