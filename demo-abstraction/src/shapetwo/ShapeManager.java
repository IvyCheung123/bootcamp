package shapetwo;

public class ShapeManager {
  private ShapeTwo shape; // attribute can be an interface

  // Design implication:
  // You should put an object which implemented the contract (interface)
  // so that the parameter object MUST contain area() method
  public ShapeManager(ShapeTwo shape) {
    this.shape = shape;
  }

  public void setShape(ShapeTwo shape) {
    this.shape = shape;
  }

  // During compile time, Java can guarentee the object is able to call area() method
  public boolean isTooBig() {
    return this.shape.area() > 20.0;
  }

  public static void main(String[] args) {
    ShapeManager shapeManager = new ShapeManager(new CircleTwo(3.0));
    System.out.println(shapeManager.isTooBig()); // true

    shapeManager.setShape(new SquareTwo(4.0));
    System.out.println(shapeManager.isTooBig()); // false
  }
}
