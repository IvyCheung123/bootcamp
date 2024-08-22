package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Objective: Learn existing interface
public class Ball2 implements Comparable<Ball2>{
  private int number;
  private Color2 color;

  public Ball2(int number, Color2 color) {
    this.number = number;
    this.color = color;
  }

  public int getNumber() {
    return this.number;
  }

  public Color2 getColor() {
    return this.color;
  }

  // @Override
  // public int compareTo(Ball2 ball) {
  //   // Objectives: Provide your own formula to sort List<Ball>
  //   // Return value: -1 or 1 (You decide which is -1 and 1 -> sorting formula)

  //   // Example 1: Sort by number (descending)
  //   // You have two Ball obj ref (ball, this)
  //   // -1 means "move to left" (from left to right)
  //   return this.number > ball.getNumber() ? -1 : 1;
  // }

  // @Override
  // public int compareTo(Ball2 ball) {
  //   return this.color.getValue() < ball.color.getValue()? -1 : 1;
  // }

  @Override
  public int compareTo(Ball2 ball) {
    if (this.color.getValue() < ball.color.getValue()) {
      return -1;
    } else if (this.color.getValue() == ball.color.getValue()) {
      if(this.number > ball.getNumber()) {
        return -1;
      }
    }
    return 1;
  }

  public String toString() {
    return "Ball2(number=" + this.number + ", color=" + this.color + ")";
  }

  public static void main(String[] args) {
    List<Ball2> balls = new ArrayList<>();
    balls.add(new Ball2(10, Color2.BLACK));
    balls.add(new Ball2(14, Color2.WHITE));
    balls.add(new Ball2(24, Color2.WHITE));
    balls.add(new Ball2(8, Color2.RED));
    System.out.println(balls); // 10 14 8

    // Approach 1
    // Collections.sort() -> call List<Ball> for loop -> call ball.compareTo()
    Collections.sort(balls);
    System.out.println(balls); // 14 10 8

    // Sort by color? RED -> WHITE -> BLACK

    // Sort by color, and then number? RED -> WHITE -> BLACK, number (descending)
    // 8 RED, 24 WHITE, 14 WHITE, 10 BLACK

    // Approach 2
    balls.add(new Ball2(11, Color2.RED));
    balls.add(new Ball2(12, Color2.BLACK));

    int x = 3;
    Comparator<Ball2> formula = null;
    if (x >= 3) {
      formula = new Ball2SortByColor();
    } else {
      // formula = new Ball2SortByNumber();
    }

    Collections.sort(balls, new Ball2SortByColor());
    System.out.println(balls); // RED RED BLACK BLACK WHITE WHITE
  }

  // Comparable: just one formula in one side
  // Comparator: can use different formula in one side
}
