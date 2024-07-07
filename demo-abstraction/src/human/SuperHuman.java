package human;

public abstract class SuperHuman {
  private double height;

  public SuperHuman() {

  }

  // Why abstract class has constructor? but we cannot create object for abstract class
  public SuperHuman(double height) {
    this.height = height;
  }

  public double getHeight() {
    return this.height;
  }
}
