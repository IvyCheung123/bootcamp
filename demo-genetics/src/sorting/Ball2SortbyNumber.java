package sorting;

import java.util.Comparator;

public class Ball2SortbyNumber implements Comparator<Ball2> {
  @Override
  public int compare(Ball2 b1, Ball2 b2) {
    // -1 represent b1, 1 represent b2
    return b1.getNumber() < b2.getNumber() ? -1 : 1;
  }
}
