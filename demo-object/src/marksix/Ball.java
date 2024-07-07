package marksix;

import java.util.Arrays;
import java.util.Objects;

public class Ball {
  
  private int number;

  public Ball(int number) {
    this.number = number;
  }

  public int getNumber() {
    return this.number;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Ball)) {
      return false;
    }
    Ball ball = (Ball) obj;
    return Objects.equals(this.number, ball.getNumber());
  }

  @Override
  public String toString() {
    return "Ball (Number: " + this.number + ")"; 
  }

  public static void main(String[] args) {
    int[] arr = new int[3];
    int[] arr2 = new int[3];
    System.out.println(Arrays.toString(arr)); // [0, 0, 0]
    System.out.println(Arrays.toString(arr2)); // [0, 0, 0]
    System.out.println(arr.equals(arr2)); // false, after override
    System.out.println(Arrays.equals(arr, arr2)); // true

    Object ball = new Ball(48);
    // ball.getNumber(); // Polymorphism (The method getNumber() is undefined for the type Object)
    System.out.println(ball.getClass()); // class marksix.Ball

    // Class<Ball> class1 = ball.getClass(); // Compile error
    Class<?> class1 = ball.getClass();
    System.out.println(class1); // class marksix.Ball

    System.out.println(ball instanceof Ball); // true
  }
}
