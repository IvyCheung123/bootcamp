package marksix;

import java.util.Objects;

public class SmallBall extends Ball {

  private String color;
  
  // constructor
  public SmallBall(int number, String color) {
    super(number);
    this.color = color;
  }

  public String getColor() {
    return this.color;
  }

  // toString()? equals()? hashCode()?
  @Override
  public String toString() {
    return "SmallBall (Number: " + super.getNumber() + ", Color: " + this.color + "); " + super.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof SmallBall)) {
      return false;
    }
    SmallBall smallBall = (SmallBall) obj;
    return Objects.equals(super.getNumber(), smallBall.getNumber())
        && Objects.equals(this.color, smallBall.getColor());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.getNumber(), this.color);
  }

  public static void main(String[] args) {
    SmallBall sm1 = new SmallBall(1, "red");
    SmallBall sm2 = new SmallBall(1, "red");
    System.out.println(sm1.hashCode()); // 113777
    System.out.println(sm2.hashCode()); // 113777
    System.out.println(sm1);
    System.out.println(sm2);
    System.out.println(sm1.equals(sm2)); // true

    SmallBall sm3 = new SmallBall(2, "red");
    System.out.println(sm3.hashCode()); // 113808
    System.out.println(sm1.equals(sm3)); // false
  }
}
