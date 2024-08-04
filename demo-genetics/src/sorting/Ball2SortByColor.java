package sorting;

import java.util.Comparator;

public class Ball2SortByColor implements Comparator<Ball2> {
  // RED -> BLACK -> WHITE
  @Override
  public int compare(Ball2 b1, Ball2 b2) {
    // -1 means puting b1 to the left
    // 1 means puting b2 to the left
    if (b1.getColor() == Color2.RED)
      return -1;
    if (b1.getColor() == Color2.BLACK && b2.getColor() == Color2.WHITE)
      return -1;
    if (b1.getColor() == Color2.BLACK && b2.getColor() == Color2.RED)
      return 1;
    if (b1.getColor() == Color2.WHITE)
      return 1;
    return 1;
  }
}
